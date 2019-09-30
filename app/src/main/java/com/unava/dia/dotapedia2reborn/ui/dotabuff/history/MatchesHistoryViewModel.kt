package com.unava.dia.dotapedia2reborn.ui.dotabuff.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.data.history.History
import com.unava.dia.dotapedia2reborn.data.history.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MatchesHistoryViewModel @Inject constructor(private val model: MatchesHistoryModel) : ViewModel() {
    val matchesHistoryResult: MutableLiveData<Boolean> = MutableLiveData()
    val matchesHistoryErrorSubject: MutableLiveData<String> = MutableLiveData()

    var matchesResult: MutableLiveData<Result> = MutableLiveData()
    var mapResult: MutableLiveData<HashMap<Int, String>> = MutableLiveData()

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    fun findHistory(id: String, KEY: String) {
        scope.launch {
            try {
                val response = model.getMatchesAsync(id, KEY)
                if (response.isSuccessful) {
                    val successHeroesResult = response.body()
                    if (successHeroesResult != null) {
                        //regen(successHeroesResult)
                        matchesResult.postValue(successHeroesResult.match)
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}