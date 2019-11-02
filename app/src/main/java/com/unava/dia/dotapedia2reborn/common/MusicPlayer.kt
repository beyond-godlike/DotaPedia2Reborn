package com.unava.dia.dotapedia2reborn.common

import android.content.Context
import android.media.MediaPlayer

class MusicPlayer(context: Context, music: Int)  {
    private var player: MediaPlayer = MediaPlayer.create(context, music)

    fun pause() {
        player.pause()
    }

    fun resume() {
        player.start()
    }

    fun stop() {
        player.stop()
        player.release()
    }

    fun start() {
        player.start()
    }
}