package com.unava.dia.dotapedia2reborn.ui.updates.update

import com.unava.dia.dotapedia2reborn.data.updates.UpdatesParser
import javax.inject.Inject

class OneUpdateModel @Inject constructor() {
    fun loadHtml(baseUrl: String) : String {
        val dirtyHtml = UpdatesParser.loadHtml(baseUrl)
        return UpdatesParser.filterHtml(dirtyHtml)
    }
}