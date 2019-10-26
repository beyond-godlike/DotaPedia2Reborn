package com.unava.dia.dotapedia2reborn.common

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageButton

/**
 * Sets an image into [ImageButton] using ktx
 *
 * @param path path to an image
 * @param context application context
 */
internal fun ImageButton.loadImage(path: String, context: Context) {
    setImageDrawable(Drawable.createFromStream(Utils.openImage(path, context), null))
}
