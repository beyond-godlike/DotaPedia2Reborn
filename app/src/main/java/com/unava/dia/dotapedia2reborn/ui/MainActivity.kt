package com.unava.dia.dotapedia2reborn.ui

import android.annotation.TargetApi
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.os.Message
import android.view.*
import android.view.View.TEXT_ALIGNMENT_CENTER
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.content.res.ResourcesCompat
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.common.DotapediaToast
import com.unava.dia.dotapedia2reborn.common.MusicObserver
import com.unava.dia.dotapedia2reborn.ui.dotabuff.DotabuffActivity
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.picker.HeroPickerActivity
import com.unava.dia.dotapedia2reborn.ui.pedia.DotapediaActivity
import com.unava.dia.dotapedia2reborn.ui.updates.UpdatesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var musicObserver: MusicObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        musicObserver = MusicObserver(this)

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
        fab.setOnClickListener {
            showToast(getRandomTip())
        }

        lifecycle.addObserver(musicObserver)

        if (getMusicPrefs()) {
            musicObserver.startMusic()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_menu, menu)
        val item = menu!!.findItem(R.id.myswitch_item)
        item.setActionView(R.layout.switch_layout)

        val mySwitch: Switch = item.actionView.findViewById(R.id.btSwitch)
        mySwitch.isChecked = getMusicPrefs()
        mySwitch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) attachMusic() else deattachMusic()
        }

        return true
    }

    private fun attachMusic() {
        setMusicPrefs(true)
        musicObserver.startMusic()
    }

    private fun deattachMusic() {
        setMusicPrefs(false)
        musicObserver.pauseMusic()
    }

    private fun setMusicPrefs(musicState: Boolean) {
        val sPref = getPreferences(MODE_PRIVATE)
        //sPref.edit { putBoolean("MUSIC_ON_OFF", musicState)}
        sPref.edit(commit = true) { putBoolean("MUSIC_ON_OFF", musicState) }

    }

    private fun getMusicPrefs(): Boolean {
        val sPref = getPreferences(MODE_PRIVATE)
        return sPref.getBoolean("MUSIC_ON_OFF", false)
    }

    private fun showToast(message: String) {
        DotapediaToast.infoToast(this, message)
    }

    private fun getRandomTip() : String {
        val tips = applicationContext.resources.getStringArray(R.array.tips)

        val pos = 1 + (Math.random() * 12).toInt()
        return tips[pos]
    }
}