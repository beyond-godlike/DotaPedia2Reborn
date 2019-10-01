package com.unava.dia.dotapedia2reborn.ui.updates.update

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.dotapedia2reborn.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_one_update.*
import org.jsoup.Jsoup
import java.io.IOException
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

    @SuppressLint("SetJavaScriptEnabled")
    private fun init() {
        webWiew.settings.javaScriptEnabled = true
        val articleUrl = intent?.extras?.getString("URL_TO_FULL_ARTICLE")

        if( articleUrl != null) {
            this.viewModel.loadArticle(articleUrl)
        }
    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(OneUpdateViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {
        this.viewModel.updateErrorSubject.observe(this, Observer {
            Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_SHORT).show()
        })
        this.viewModel.article.observe(this, Observer {
            webWiew.loadDataWithBaseURL("", it, "text/html","UTF-8", "")
        })
    }
}
