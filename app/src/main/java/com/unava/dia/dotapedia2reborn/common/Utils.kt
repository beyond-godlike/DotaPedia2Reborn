package com.unava.dia.dotapedia2reborn.common

import android.content.Context
import java.io.IOException
import java.io.InputStream


class Utils {
    companion object {
        fun calculateColumns(context: Context, imageWidth: Int): Int {
            val displayMetrics = context.resources.displayMetrics
            val dpWidth = displayMetrics.widthPixels / displayMetrics.density

            return (dpWidth / (imageWidth + 20)).toInt()
        }

        fun openImage(path: String, c: Context): InputStream? {
            val am = c.resources.assets
            var stream: InputStream? = null

            try {
                stream = am.open(path)
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return stream
        }

    }
}