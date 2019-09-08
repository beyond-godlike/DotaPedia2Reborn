package com.unava.dia.dotapedia2reborn.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class GlideUtils {
    companion object {
        fun setImageUrl(imageView: ImageView, imageUrl: String, imageWidth: Int, imageHeight: Int) {
            val context = imageView.context

            Glide.with(context).load(imageUrl)
                .apply(RequestOptions().override(imageWidth, imageHeight))
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

            Glide.with(context).load(imageUrl)
                .into(imageView)
        }
    }
}