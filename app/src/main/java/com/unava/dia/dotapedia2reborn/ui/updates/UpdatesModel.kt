package com.unava.dia.dotapedia2reborn.ui.updates

import org.jsoup.Jsoup
import javax.inject.Inject

class UpdatesModel @Inject constructor() {
    fun getUpdates() : String {
        val doc = Jsoup.connect("http://www.dota2.com/news/updates/?l=russian")
            .userAgent("Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B)")
            .get()

        return doc.outerHtml()

    }
}