package com.unava.dia.dotapedia2reborn.ui.updates

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.data.articles.UpdatesEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class UpdatesViewModel @Inject constructor(private val model: UpdatesModel) : ViewModel() {
    val updatesErrorSubject: MutableLiveData<String> = MutableLiveData()

    val articlesList: MutableLiveData<List<UpdatesEntity>> = MutableLiveData()

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    fun loadArticles() {
        scope.launch {
            try {
                model.insertUpdates()
                val result = model.getUpdates()
                if(result.isEmpty()) {
                    updatesErrorSubject.postValue("db is null")
                }
                articlesList.postValue(result)
            } catch (e: Exception) {
                e.printStackTrace()
                updatesErrorSubject.postValue(e.localizedMessage)
            }
        }
    }
}