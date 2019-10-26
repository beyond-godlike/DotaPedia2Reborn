package com.unava.dia.dotapedia2reborn.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.core.content.edit
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.ui.dotabuff.DotabuffActivity
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.picker.HeroPickerActivity
import com.unava.dia.dotapedia2reborn.common.MusicObserver
import com.unava.dia.dotapedia2reborn.ui.pedia.DotapediaActivity
import com.unava.dia.dotapedia2reborn.ui.updates.UpdatesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
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
        fab.setOnClickListener {
            // TODO implement click listener
        }

        if (getMusicPrefs()) {
            lifecycle.addObserver(MusicObserver(this))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.isChecked) {
            true -> {
                setMusicPrefs(true)
                item.icon = resources.getDrawable(R.drawable.mute)
                item.isChecked = false
                return true
            }
            false -> {
                setMusicPrefs(false)
                item.icon = resources.getDrawable(R.drawable.unmute)
                item.isChecked = true
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_activity_menu, menu)
        val menuBuilder: MenuBuilder = menu!! as MenuBuilder
        menuBuilder.setOptionalIconsVisible(true)

        return true
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
}
