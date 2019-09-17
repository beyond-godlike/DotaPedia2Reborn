package com.unava.dia.dotapedia2reborn.ui.dotabuff.checker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.dotapedia2reborn.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class MmrCheckerActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var viewModel: MmrCheckerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mmr_checker)
        AndroidInjection.inject(this)
        this.bindViewModel()
        init()
    }

    private fun init() {

    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(MmrCheckerViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {

    }
}
