package com.unava.dia.dotapedia2reborn.ui.updates

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.ui.updates.update.OneUpdateActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_updates.*
import javax.inject.Inject

class UpdatesActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var viewModel: UpdatesViewModel

    private lateinit var adapter: UpdatesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updates)
        AndroidInjection.inject(this)
        this.bindViewModel()
        init()
    }

    private fun init() {
        this.viewModel.loadArticles()
        initRecyclerView()
    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(UpdatesViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {
        this.viewModel.updatesErrorSubject.observe(this, Observer {
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        })
        this.viewModel.articlesList.observe(this, Observer {
            adapter.updateData(it)
        })
    }

    private fun initRecyclerView(){
        adapter = UpdatesAdapter()
        rvUpdates.adapter = adapter
        rvUpdates.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL ,false)

        adapter.onItemClick = { it ->
            val intent = Intent(this, OneUpdateActivity::class.java)
            intent.putExtra("UPDATE_NUMBER", it)
            intent.putExtra("URL_TO_FULL_ARTICLE", viewModel.articlesList.value?.get(it)?.urlToFullArticle)
            startActivity(intent)
        }
    }
}
