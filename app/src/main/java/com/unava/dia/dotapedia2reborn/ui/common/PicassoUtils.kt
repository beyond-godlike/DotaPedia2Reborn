package com.unava.dia.dotapedia2reborn.ui.common

import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.unava.dia.dotapedia2reborn.ui.common.ProjectConstants.Companion.IMAGE_ONE_MATCH_HERO_HEIGHT
import com.unava.dia.dotapedia2reborn.ui.common.ProjectConstants.Companion.IMAGE_ONE_MATCH_HERO_WIDTH

class PicassoUtils {
    companion object {
        private fun setImageUrl(imageView: ImageView, imageUrl: String, imageWidth: Int, imageHeight: Int) {
            Picasso.with(imageView.context)
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

            setImageUrl(
                imageView,
                imageUrl,
                imageWidth,
                imageHeight
            )
        }

        fun setPlayerIcon(imageView: ImageView, avatarUrl: String) {
            val imageUrl = StringBuilder()
                .append(avatarUrl)
                .toString()

            Picasso.with(imageView.context).load(imageUrl)
                .into(imageView)
        }

        fun setHeroIconSmall(imageView: ImageView, imageName: String) {
            var url = imageName.replace("npc_dota_hero_", "http://cdn.dota2.com/apps/dota2/images/heroes/")
            url += "_sb.png"

            val imageUrl = StringBuilder()
                .append(url)
                .toString()

            Picasso.with(imageView.context)
                .load(imageUrl)
                .resize(IMAGE_ONE_MATCH_HERO_WIDTH, IMAGE_ONE_MATCH_HERO_HEIGHT)
                .into(imageView)
        }
    }
}