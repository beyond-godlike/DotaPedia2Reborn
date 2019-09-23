package com.unava.dia.dotapedia2reborn.ui.updates

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.data.updates.UpdateArticle
import com.unava.dia.dotapedia2reborn.data.updates.UpdatesParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class UpdatesViewModel @Inject constructor(private val model: UpdatesModel) : ViewModel() {
    val updatesErrorSubject: MutableLiveData<String> = MutableLiveData()

    val articlesList: MutableLiveData<List<UpdateArticle>> = MutableLiveData()

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    fun loadArticles() {
        scope.launch {
            try {
//                val response = model.getUpdates().flatMap {
//                    string -> UpdatesParser.parseHtml(string.toString()).orEmpty()
//                }
//                articlesList.postValue(response)

                val html = model.getUpdates()
                val result = UpdatesParser.parseHtml(html)
                articlesList.postValue(result)
            } catch (e: Exception) {
                e.printStackTrace()
                updatesErrorSubject.postValue(e.localizedMessage)
            }
        }
    }
}