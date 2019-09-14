package com.unava.dia.dotapedia2reborn.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

class PicassoUtils {
    companion object {
        private fun setImageUrl(imageView: ImageView, imageUrl: String, imageWidth: Int, imageHeight: Int) {
            val context = imageView.context

            Picasso.with(context)
                .load(imageUrl)
                .resize(imageWidth, imageHeight)
                .centerCrop()
                .into(imageView)
        }

        fun setImageHero(imageView: ImageView, rname: String, imageWidth: Int, imageHeight: Int) {
            val imageUrl = StringBuilder()
                .append("http://cdn.dota2.com/apps/dota2/images/heroes/")
                .append(rname)
                .append("_lg.png")
                .toString()

            setImageUrl(imageView, imageUrl, imageWidth, imageHeight)
        }

        fun setPlayerIcon(imageView: ImageView, avatarUrl: String) {
            val imageUrl = StringBuilder()
                .append(avatarUrl)
                .toString()

            val context = imageView.context

            Picasso.with(context).load(imageUrl)
                .into(imageView)
        }
    }
}