package com.unava.dia.dotapedia2reborn.common

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.unava.dia.dotapedia2reborn.R

// TODO add viewmodel. viewmodel gonna decide when 2 play music
class MusicObserver(context: Context) : LifecycleObserver {
    private var player: MediaPlayer = MediaPlayer.create(context, R.raw.maintheme)

//    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
//    fun start() {
//        player.start()
//    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause() {
        player.pause()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {
        player.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stop() {
        player.stop()
        player.release()
    }

    fun startMusic() {
        player.start()
    }

    fun stopMusic() {
        player.stop()
        player.release()
    }

    fun pauseMusic() {
        player.pause()
    }
}