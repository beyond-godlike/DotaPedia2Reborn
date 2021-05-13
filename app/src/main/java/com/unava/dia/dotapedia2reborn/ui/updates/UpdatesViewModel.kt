package com.unava.dia.dotapedia2reborn.ui.updates

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.data.updates.UpdatesEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class UpdatesViewModel @Inject constructor(private val model: UpdatesModel) : ViewModel() {
    val updatesErrorSubject: MutableLiveData<String> = MutableLiveData()

    val articlesList: MutableLiveData<List<UpdatesEntity>> = MutableLiveData()
    var page: MutableLiveData<Int> = MutableLiveData()

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    init {
        page.value = 1
    }

    fun loadArticles(pos: Int) {
        scope.launch {
            try {
                model.insertUpdates(pos)
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

    fun loadNext() {
        page.value = page.value?.plus(1)
    }

    fun loadPrevious() {
        page.value = page.value?.minus(1)
    }

    fun clearAllArticles() {
        scope.launch {
            try {
                model.clearAllUpdates()
            } catch (e: Exception) {
                e.printStackTrace()
                updatesErrorSubject.postValue(e.localizedMessage)
            }
        }
    }
}