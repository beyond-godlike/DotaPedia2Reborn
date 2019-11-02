package com.unava.dia.dotapedia2reborn.ui.main

import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.view.*
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.common.DotapediaToast
import com.unava.dia.dotapedia2reborn.common.MusicPlayer
import com.unava.dia.dotapedia2reborn.common.ProjectConstants
import com.unava.dia.dotapedia2reborn.ui.dotabuff.DotabuffActivity
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.picker.HeroPickerActivity
import com.unava.dia.dotapedia2reborn.ui.pedia.DotapediaActivity
import com.unava.dia.dotapedia2reborn.ui.updates.UpdatesActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        this.bindViewModel()
        initUI()
    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {
        // TODO not implemented in this version
    }

    private fun initUI() {
        if(getMusicPrefs()) {
            this.viewModel.playerState(ProjectConstants.START)
        }
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
        this.viewModel.playerState(ProjectConstants.START)
    }

    private fun deattachMusic() {
        setMusicPrefs(false)
        this.viewModel.playerState(ProjectConstants.PAUSE)
    }

    private fun setMusicPrefs(musicState: Boolean) {
        val sPref = getPreferences(MODE_PRIVATE)
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

    override fun onPause() {
        super.onPause()
        this.viewModel.playerState(ProjectConstants.PAUSE)
    }

    override fun onResume() {
        super.onResume()
        if(getMusicPrefs()) {
            this.viewModel.playerState(ProjectConstants.RESUME)
        }
    }
}