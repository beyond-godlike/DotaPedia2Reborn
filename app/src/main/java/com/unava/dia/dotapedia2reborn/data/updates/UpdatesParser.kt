package com.unava.dia.dotapedia2reborn.data.updates

import org.jsoup.Jsoup



class UpdatesParser {
    companion object {
        fun parseHtml(html: String): List<UpdateArticle>? {
            val cards: ArrayList<UpdateArticle> = ArrayList()

            try {
                val doc = Jsoup.parse(html)

                val elements = doc.select("div#mainLoop").first().children()

                for (i in 0 until elements.size) {
                    val el = elements[i]

                    val card = UpdateArticle()

                    card.date = el.select("div.entry-meta").text()
                    card.description = el.select("div.entry-content").html()
                    card.title = el.select("h2.entry-title").text()
                    card.urlToFullArticle = el.select("h2.entry-title").select("a").attr("href")

                    if (card.title.equals("")) {
                    } else {
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