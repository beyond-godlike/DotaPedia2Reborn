package com.unava.dia.dotapedia2reborn.ui.heroConstructor.picker

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.utils.ProjectConstants
import com.unava.dia.dotapedia2reborn.utils.Utils
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_hero_picker.*
import javax.inject.Inject

class HeroPickerActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var viewModel: HeroPickerViewModel

    private lateinit var adapter: HeroPickerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_picker)
        AndroidInjection.inject(this)
        this.bindViewModel()
        init()
    }

    private fun init() {
        viewModel.loadHeroes(this.applicationContext)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val columns = Utils.calculateColumns(applicationContext, ProjectConstants.IMAGE_HERO_SMALL_WIDTH)
        rvHeroes.layoutManager = GridLayoutManager(applicationContext, columns)
    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(HeroPickerViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {
        this.viewModel.heroes.observe(this, Observer {
            adapter = HeroPickerAdapter(it, this)
            rvHeroes.adapter = adapter
        })
    }
}
