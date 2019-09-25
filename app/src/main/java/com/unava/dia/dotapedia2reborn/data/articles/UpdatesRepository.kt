package com.unava.dia.dotapedia2reborn.data.articles

import androidx.lifecycle.LiveData
import org.jsoup.Jsoup
import javax.inject.Inject

class UpdatesRepository @Inject constructor(private val updatesDao: UpdatesDao) {
    fun getUpdates() : LiveData<List<UpdatesEntity>> {
        return updatesDao.loadUpdates()
    }
}