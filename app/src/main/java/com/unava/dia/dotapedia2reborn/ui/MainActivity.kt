package com.unava.dia.dotapedia2reborn.ui

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.ui.dotabuff.DotabuffActivity
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.picker.HeroPickerActivity
import com.unava.dia.dotapedia2reborn.ui.pedia.DotapediaActivity
import com.unava.dia.dotapedia2reborn.ui.updates.UpdatesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var player: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        btPedia.setOnClickListener {
            startActivity(Intent(this, DotapediaActivity::class.java))
        }
        btUpdates.setOnClickListener {
            startActivity(Intent(this, UpdatesActivity::class.java))
        }
        btDotabuff.setOnClickListener {
            startActivity(Intent(this, DotabuffActivity::class.java))
        }
        btHeroConstructor.setOnClickListener {
            startActivity(Intent(this, HeroPickerActivity::class.java))
        }

        player = MediaPlayer.create(this, R.raw.maintheme)
        player?.start()
    }

    override fun onDestroy() {
        super.onDestroy()

        player?.release()
        player = null
    }



}
