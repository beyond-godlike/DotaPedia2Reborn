package com.unava.dia.dotapedia2reborn.ui.updates.update

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.dotapedia2reborn.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class OneUpdateActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var viewModel: OneUpdateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_update)
        AndroidInjection.inject(this)
        this.bindViewModel()
        init()
    }

    private fun init() {

    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(OneUpdateViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {

    }
}
