package com.unava.dia.dotapedia2reborn.ui.updates.update

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.dotapedia2reborn.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_one_update.*
import javax.inject.Inject

class OneUpdateActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var viewModel: OneUpdateViewModel

    private var articleUrl: String? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_update)
        AndroidInjection.inject(this)
        this.bindViewModel()
        init()

        webWiew.settings.javaScriptEnabled = true
        if(savedInstanceState != null) {
            articleUrl = savedInstanceState.getString("URL_TO_FULL_ARTICLE")
        }
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
