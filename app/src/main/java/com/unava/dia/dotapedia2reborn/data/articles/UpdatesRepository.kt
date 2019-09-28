package com.unava.dia.dotapedia2reborn.data.articles

import javax.inject.Inject

class UpdatesRepository @Inject constructor(private val updatesDao: UpdatesDao) {
    fun getUpdates() : List<UpdatesEntity> {
        return updatesDao.getUpdates()
    }

    fun insertUpdate(update: UpdatesEntity) {
        updatesDao.insertUpdate(update)
    }
}