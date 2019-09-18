package com.unava.dia.dotapedia2reborn.ui.dotabuff.checker

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.data.mmrChecker.AccInformation
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MmrCheckerViewModel @Inject constructor(private val model: MmrCheckerModel) : ViewModel() {
    val requestError: MutableLiveData<String> = MutableLiveData()
    var accInfo: MutableLiveData<AccInformation> = MutableLiveData()

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    fun fetchAccInfo(id: String) {
        scope.launch {
            try {
                val response = model.getPlayerInfoAsync(id)
                if (response.isSuccessful) {
                    val successResult = response.body()
                    if (successResult != null) {
                        accInfo.postValue(successResult)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                requestError.postValue(e.localizedMessage)
            }
        }
    }

    private fun cancelAllRequests() = coroutineContext.cancel()

    override fun onCleared() {
        super.onCleared()
        cancelAllRequests()
    }
}