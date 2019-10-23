package com.unava.dia.dotapedia2reborn.common

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.unava.dia.dotapedia2reborn.R

class MusicObserver(context: Context) : LifecycleObserver{
    private var player: MediaPlayer = MediaPlayer.create(context, R.raw.maintheme)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun timeToStartMusic() {
        player.start()
    }

//    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
//    fun pauseMusic() {
//        player.pause()
//    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resumeMusic() {
        player.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stop() {
        player.stop()
        player.release()
    }
}