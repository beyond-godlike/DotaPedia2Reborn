package com.unava.dia.dotapedia2reborn.ui.pedia

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Menu
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.data.DotaHero
import com.unava.dia.dotapedia2reborn.data.heroes.Hero
import com.unava.dia.dotapedia2reborn.ui.common.RecyclerViewClickListener
import com.unava.dia.dotapedia2reborn.ui.common.Utils
import dagger.android.AndroidInjection
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_dotapedia.*
import kotlinx.android.synthetic.main.dotapedia_content.*
import javax.inject.Inject

class DotapediaActivity : AppCompatActivity(), RecyclerViewClickListener {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var viewModel: DotapediaViewModel

    var heroes: ArrayList<Hero>  = ArrayList()
    lateinit var listHeroImages: RealmResults<DotaHero>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dotapedia)
        AndroidInjection.inject(this)
        this.bindViewModel()
        init()
    }

    private fun init() {
        tvHeroHistory.movementMethod = ScrollingMovementMethod()
        // TODO take from viewmodel
        // TODO listHeroImages: MutableLiveData -> observe -> show hero
        //listHeroImages = Utils.getHeroPediaList(applicationContext)
        //heroes = Utils.getHeroList(this)
        showHero(0)
    }

    private fun showHero(heroId: Int) {

        val path = listHeroImages[heroId]?.icon

        ivHeroIcon.setImageDrawable(setImage(path!!))
        skill1.setImageDrawable(setImage(listHeroImages[heroId]!!.skill1))
        skill2.setImageDrawable(setImage(listHeroImages[heroId]!!.skill2))
        skill3.setImageDrawable(setImage(listHeroImages[heroId]!!.skill3))
        skill6.setImageDrawable(setImage(listHeroImages[heroId]!!.skill6))

    }

    private fun setImage(path: String) : Drawable {
        return Drawable.createFromStream(Utils.openImage(path, applicationContext), null)
    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(DotapediaViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {

    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_dotapedia_drawer, menu)
        return true
    }

    override fun onItemClick(position: Int) {
        showHero(position)
    }
}
