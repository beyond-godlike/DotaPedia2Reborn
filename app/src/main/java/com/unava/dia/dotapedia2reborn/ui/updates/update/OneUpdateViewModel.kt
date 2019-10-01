package com.unava.dia.dotapedia2reborn.ui.updates.update

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import java.io.IOException
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class OneUpdateViewModel @Inject constructor(private val model: OneUpdateModel) : ViewModel() {
    val updateErrorSubject: MutableLiveData<String> = MutableLiveData()
    var article: MutableLiveData<String> = MutableLiveData()

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    fun loadArticle(articleUrl: String) {
        scope.launch {
            try {
                val result = model.loadHtml(articleUrl)
                if(result.isEmpty()) {
                    updateErrorSubject.postValue("article is null")
                }
                article.postValue(result)
            } catch (e: Exception) {
                e.printStackTrace()
                updateErrorSubject.postValue(e.localizedMessage)
            }
        }
    }
}