package com.unava.dia.dotapedia2reborn.ui.pedia

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.common.Utils
import com.unava.dia.dotapedia2reborn.data.DotaHero
import dagger.android.AndroidInjection
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_dotapedia.*
import kotlinx.android.synthetic.main.dotapedia_content.*
import com.unava.dia.dotapedia2reborn.common.*
import javax.inject.Inject

class DotapediaActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var viewModel: DotapediaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dotapedia)
        AndroidInjection.inject(this)
        this.bindViewModel()
        init()
    }

    private fun init() {
        tvHeroHistory.movementMethod = ScrollingMovementMethod()
        this.viewModel.loadHeroes()
        this.viewModel.loadHero()
    }

    private fun showHero(hero: DotaHero) {
        tvHeroName.text = hero.name
        tvHeroHistory.text = hero.history
        ivHeroIcon.setImageDrawable(setImage(hero.icon))
        skill1.loadImage(hero.skill1, applicationContext)
        skill2.loadImage(hero.skill2, applicationContext)
        skill3.loadImage(hero.skill3, applicationContext)
        if(hero.skill4.isNotEmpty()) {
            skill4.visibility = View.VISIBLE
            skill4.loadImage(hero.skill4, applicationContext)
        } else {
            skill4.visibility = View.GONE
        }
        if(hero.skill5.isNotEmpty()) {
            skill5.visibility = View.VISIBLE
            skill5.loadImage(hero.skill4, applicationContext)
        } else {
            skill5.visibility = View.GONE
        }
        skill6.loadImage(hero.skill6, applicationContext)
        tvStrength.text = hero.strength.toString()
        tvAgility.text = hero.agility.toString()
        tvIntelligence.text = hero.intelligence.toString()
        tvSpeed.text = "speed: ".plus(hero.speed.toString())
        tvDamage.text = "base damage: ".plus(
            hero.baseDamage1.toInt().toString()
                .plus(" - ")
                .plus(hero.baseDamage2.toInt().toString())
        )
        tvArmor.text = "armor: ".plus(hero.physarmor.toInt().toString())
    }

    private fun setImage(path: String) : Drawable {
        return Drawable.createFromStream(Utils.openImage(path, applicationContext), null)
    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(DotapediaViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {
        this.viewModel.heroes.observe(this, Observer {
            initAdapter(it)
        })
        this.viewModel.currentHeroId.observe(this, Observer {
            this.viewModel.loadHero()
        })
        this.viewModel.hero.observe(this, Observer {
            showHero(it)
        })
    }

    private fun initAdapter(heroes: RealmResults<DotaHero>) {
        val adapter = DotapediaAdapter(heroes)
        rvChooseHeroDrawer.adapter = adapter
        rvChooseHeroDrawer.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)

        adapter.onItemClick = {
            this.viewModel.changeCurrentHeroId(it)
        }

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

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        this.viewModel.changeCurrentHeroId(p0.itemId)

        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
