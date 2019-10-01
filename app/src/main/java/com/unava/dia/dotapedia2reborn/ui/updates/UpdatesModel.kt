package com.unava.dia.dotapedia2reborn.ui.updates

import com.unava.dia.dotapedia2reborn.BuildConfig
import com.unava.dia.dotapedia2reborn.data.updates.UpdatesEntity
import com.unava.dia.dotapedia2reborn.data.updates.UpdatesParser
import com.unava.dia.dotapedia2reborn.data.updates.UpdatesRepository
import javax.inject.Inject

class UpdatesModel @Inject constructor(private val updatesRepository: UpdatesRepository) {
    fun getUpdates(): List<UpdatesEntity> {
        return updatesRepository.getUpdates()
    }

    fun insertUpdates() {
        val html = UpdatesParser.loadHtml(BuildConfig.UPDATES_URL)
        val updatesList = UpdatesParser.parseHtml(html)
        updatesList?.forEach {
            updatesRepository.insertUpdate(it)
        }
    }
}