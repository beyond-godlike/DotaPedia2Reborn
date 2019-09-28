package com.unava.dia.dotapedia2reborn.ui.updates.update

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        // TODO remove later
        Toast.makeText(applicationContext, intent.extras.getString("URL_TO_FULL_ARTICLE"), Toast.LENGTH_SHORT).show()
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
