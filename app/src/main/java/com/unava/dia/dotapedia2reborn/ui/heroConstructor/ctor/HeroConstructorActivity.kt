package com.unava.dia.dotapedia2reborn.ui.heroConstructor.ctor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.dotapedia2reborn.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class HeroConstructorActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var viewModel: HeroConstructorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_ctor)
        AndroidInjection.inject(this)
        this.bindViewModel()
    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(HeroConstructorViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {

    }

}
