package com.unava.dia.dotapedia2reborn.ui

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
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

        if (getMusicPrefs()) {
            player = MediaPlayer.create(this, R.raw.maintheme)
            player?.start()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        super.onOptionsItemSelected(item)
        return when (item!!.isChecked) {
            true -> {
                setMusicPrefs(true)
                player?.start()
                item.icon = resources.getDrawable(R.drawable.mute)
                item.isChecked = false
                true
            }
            false -> {
                setMusicPrefs(false)
                player?.pause()
                item.icon = resources.getDrawable(R.drawable.unmute)
                item.isChecked = true
                true
            }
        }
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
        val editor = sPref.edit()
        editor.putBoolean("MUSIC_ON_OFF", musicState)
        editor.apply()
    }

    private fun getMusicPrefs(): Boolean {
        val sPref = getPreferences(MODE_PRIVATE)
        return sPref.getBoolean("MUSIC_ON_OFF", false)
    }

    override fun onDestroy() {
        super.onDestroy()

        player?.release()
        player = null
    }
}
