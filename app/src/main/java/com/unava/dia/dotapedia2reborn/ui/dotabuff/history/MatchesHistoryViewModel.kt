package com.unava.dia.dotapedia2reborn.ui.dotabuff.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.data.history.HeroInfo
import com.unava.dia.dotapedia2reborn.data.history.HistoryMatch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MatchesHistoryViewModel @Inject constructor(private val model: MatchesHistoryModel) : ViewModel() {
    val matchesHistoryResult: MutableLiveData<Boolean> = MutableLiveData()
    val matchesHistoryErrorSubject: MutableLiveData<String> = MutableLiveData()

    var matchesResult: MutableLiveData<ArrayList<HistoryMatch>> = MutableLiveData()
    var heroesResult: MutableLiveData<ArrayList<HeroInfo>> = MutableLiveData()

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    fun findHistory(id: String) {
        getHeroesInfo()

        scope.launch {
            try {
                val response = model.getMatchesAsync(id)
                if (response.isSuccessful) {
                    val successResult = response.body()
                    if (successResult != null) {
                        matchesResult.postValue(successResult)
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun getHeroesInfo() {
        scope.launch {
            try {
                val response = model.getHeroesInfoAsync()
                if (response.isSuccessful) {
                    val successResult = response.body()
                    if (successResult != null) {
                        heroesResult.postValue(successResult)
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}