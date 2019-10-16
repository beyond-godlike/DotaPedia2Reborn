package com.unava.dia.dotapedia2reborn.ui.dotabuff.history

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.data.history.HeroInfo
import com.unava.dia.dotapedia2reborn.data.history.HistoryMatch
import com.unava.dia.dotapedia2reborn.ui.dotabuff.match.MatchActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_matches_history.*
import javax.inject.Inject

class MatchesHistoryActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var viewModel: MatchesHistoryViewModel

    lateinit var heroes: ArrayList<HeroInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matches_history)
        AndroidInjection.inject(this)
        this.bindViewModel()
        init()
    }

    private fun init() {
        val playerId = intent.extras.getString("PLAYER_ID")
        if (playerId != null) {
            this.viewModel.findHistory(playerId)
        }
    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(MatchesHistoryViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {
        this.viewModel.matchesHistoryErrorSubject.observe(this, Observer { error ->
            Toast.makeText(applicationContext, error, Toast.LENGTH_LONG).show()
        })
        this.viewModel.heroesResult.observe(this, Observer {
            this.heroes = it
        })
        this.viewModel.matchesResult.observe(this, Observer {
            initAdapter(it)
        })
    }

    private fun initAdapter(history: ArrayList<HistoryMatch>) {
        val adapter = MatchesHistoryAdapter(heroes, history)
        rvMatchesHistory.adapter = adapter
        rvMatchesHistory.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)

        adapter.onItemClick = {
            val intent = Intent(this, MatchActivity::class.java)
            intent.putExtra("MATCH_NUMBER", it)
            startActivity(intent)
        }
    }
}
