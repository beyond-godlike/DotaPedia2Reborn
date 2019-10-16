package com.unava.dia.dotapedia2reborn.ui.dotabuff.match

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unava.dia.dotapedia2reborn.BuildConfig
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.data.match.Match
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_match.*
import javax.inject.Inject

class MatchActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var viewModel: MatchViewModel

    // TODO shouldn`t be here
    private var heroesMap: HashMap<Int, String> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)
        AndroidInjection.inject(this)
        this.bindViewModel()
        init()
    }

    private fun init() {
        val matchId = intent.extras.getString("MATCH_NUMBER")
        if(matchId != null) {
            this.viewModel.getMatch(matchId, BuildConfig.SteamAPIKEY)
        }
    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(MatchViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {
        this.viewModel.oneMatchResult.observe(this, Observer {
            //Toast.makeText(applicationContext, "Success!!", Toast.LENGTH_LONG).show()
        })
        this.viewModel.oneMatchErrorSubject.observe(this, Observer { error ->
            Toast.makeText(applicationContext, error, Toast.LENGTH_LONG).show()
        })
        this.viewModel.mapResult.observe(this, Observer { map ->
            heroesMap = map
        })
        this.viewModel.matchResult.observe(this, Observer { player ->
            initAdapter(player.match!!)
        })
    }

    private fun initAdapter(match: Match) {
        val adapter = MatchAdapter(match.players!!, heroesMap)
        rvMatchStats.adapter = adapter
        rvMatchStats.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL ,false)
    }


}
