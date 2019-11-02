package com.unava.dia.dotapedia2reborn.ui.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.common.MusicPlayer
import com.unava.dia.dotapedia2reborn.common.ProjectConstants
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val context: Context,
    private val model: MainModel
) : ViewModel(){
    private var mPlayer: MutableLiveData<MusicPlayer> = MutableLiveData()

    init {
        mPlayer.value = MusicPlayer(context, R.raw.maintheme)
    }

    fun playerState(state: String) {
        when(state) {
            ProjectConstants.START -> mPlayer.value?.start()
            ProjectConstants.STOP -> mPlayer.value?.stop()
            ProjectConstants.PAUSE -> mPlayer.value?.pause()
            ProjectConstants.RESUME -> mPlayer.value?.resume()
        }
    }
}