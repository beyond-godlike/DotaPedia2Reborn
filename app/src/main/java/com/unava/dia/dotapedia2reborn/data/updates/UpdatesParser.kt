package com.unava.dia.dotapedia2reborn.data.updates

import com.unava.dia.dotapedia2reborn.data.articles.UpdatesEntity
import org.jsoup.Jsoup



class UpdatesParser {
    companion object {
        fun loadHtml() : String {
            val doc = Jsoup.connect("http://www.dota2.com/news/updates/?l=russian")
                .userAgent("Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B)")
                .get()

            return doc.outerHtml()
        }

        fun parseHtml(html: String): List<UpdatesEntity>? {
            val cards: ArrayList<UpdatesEntity> = ArrayList()

            try {
                val doc = Jsoup.parse(html)

                val elements = doc.select("div#mainLoop").first().children()

                for (i in 0 until elements.size) {
                    val el = elements[i]

                    if(el.select("h2.entry-title").text() == "") {

                    }
                    else {
                        val card = UpdatesEntity(
                            el.select("div.entry-meta").text(),
                            el.select("div.entry-content").html(),
                            el.select("h2.entry-title").text(),
                            el.select("h2.entry-title").select("a").attr("href")
                        )
                        cards.add(card)
                    }
                }
            } catch (t: Throwable) {
                return null
            }

            return cards
        }
    }
}