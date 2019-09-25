package com.unava.dia.dotapedia2reborn.ui.updates

import androidx.lifecycle.LiveData
import com.unava.dia.dotapedia2reborn.data.articles.UpdatesEntity
import com.unava.dia.dotapedia2reborn.data.articles.UpdatesRepository
import javax.inject.Inject

class UpdatesModel @Inject constructor(private val updatesRepository: UpdatesRepository) {
    fun getUpdates() : LiveData<List<UpdatesEntity>> {
        return  updatesRepository.getUpdates()
    }
}