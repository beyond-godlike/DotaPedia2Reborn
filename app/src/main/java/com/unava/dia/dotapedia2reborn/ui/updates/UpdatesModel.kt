package com.unava.dia.dotapedia2reborn.ui.updates

import com.unava.dia.dotapedia2reborn.data.articles.UpdatesEntity
import com.unava.dia.dotapedia2reborn.data.articles.UpdatesParser
import com.unava.dia.dotapedia2reborn.data.articles.UpdatesRepository
import javax.inject.Inject

class UpdatesModel @Inject constructor(private val updatesRepository: UpdatesRepository) {
    fun getUpdates() : List<UpdatesEntity> {
        return  updatesRepository.getUpdates()
    }
    fun insertUpdates() {
        val html = UpdatesParser.loadHtml()
        val updatesList = UpdatesParser.parseHtml(html)
        updatesList?.forEach {
            updatesRepository.insertUpdate(it)
        }
    }
}