package com.unava.dia.dotapedia2reborn.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Inflates a layout for [ViewGroup] using ktx
 *
 * @param layoutRes resource layout
 */
internal fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

