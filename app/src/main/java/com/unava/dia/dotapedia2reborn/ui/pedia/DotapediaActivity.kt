package com.unava.dia.dotapedia2reborn.ui.pedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.dotapedia2reborn.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class DotapediaActivity : AppCompatActivity() {

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

    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(DotapediaViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {

    }

}
