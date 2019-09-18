package com.unava.dia.dotapedia2reborn.ui.dotabuff.history

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.dotapedia2reborn.BuildConfig
import com.unava.dia.dotapedia2reborn.R
import dagger.android.AndroidInjection

import kotlinx.android.synthetic.main.activity_matches_history.*
import javax.inject.Inject

class MatchesHistoryActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var viewModel: MatchesHistoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matches_history)
        AndroidInjection.inject(this)
        this.bindViewModel()
        init()
    }

    private fun init() {
        val playerId = intent.extras.getString("PLAYER_ID")
        if(playerId != null) {
            //this.viewModel.findHistory(playerId, BuildConfig.SteamAPIKEY)
        }
    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(MatchesHistoryViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {

    }

}
