package com.unava.dia.dotapedia2reborn.ui.dotabuff.checker

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.utils.PicassoUtils
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_mmr_checker.*
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
        btSearchPlayer.setOnClickListener {
            viewModel.fetchAccInfo(etPlayerId.text.toString())
        }

        val playerId = intent.extras?.getString("PLAYER_ID")
        if (playerId != null) {
            etPlayerId.setText(playerId)
            this.viewModel.fetchAccInfo(etPlayerId.text.toString())
        }
    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(MmrCheckerViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {
        this.viewModel.requestError.observe(this, Observer { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        })
        this.viewModel.accInfo.observe(this, Observer {
            PicassoUtils.setPlayerIcon(ivPlayerIcon, it?.profile?.avatarfull.toString())
            tvEstimatedMmr.text = it?.mmr_estimate?.estimate.toString()
            tvSoloMmr.text = it?.solo_competitive_rank
            tvPartyMmr.text = it?.competitive_rank
        })
    }
}
