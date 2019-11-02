package com.unava.dia.dotapedia2reborn.common

import android.app.Activity
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.unava.dia.dotapedia2reborn.R
import kotlinx.android.synthetic.main.toast.view.*

class DotapediaToast {
    companion object {
        private lateinit var layoutInflater: LayoutInflater

        fun infoToast(context: Activity, message: String) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(R.layout.toast, (context).findViewById(R.id.toast_layout))
            val drawable = ContextCompat.getDrawable(context, R.drawable.toast_style)
            drawable?.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(context, R.color.colorToastBackground)
                , PorterDuff.Mode.MULTIPLY)
            layout.background = drawable
            layout.tvToast.setTextColor(Color.BLACK)
            layout.tvToast.text = message
            val toast = Toast(context.applicationContext)
            toast.duration = Toast.LENGTH_SHORT
            toast.view = layout
            toast.show()
        }
    }
}