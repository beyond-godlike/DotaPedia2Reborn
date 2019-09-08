package com.unava.dia.dotapedia2reborn.utils

import android.content.Context


class Utils {
    companion object {
        fun calculateColumns(context: Context, imageWidth: Int): Int {
            val displayMetrics = context.resources.displayMetrics
            val dpWidth = displayMetrics.widthPixels / displayMetrics.density

            return (dpWidth / (imageWidth + 20)).toInt()
        }

    }
}