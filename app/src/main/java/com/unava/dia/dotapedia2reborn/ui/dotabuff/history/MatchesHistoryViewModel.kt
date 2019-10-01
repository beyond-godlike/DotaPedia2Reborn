package com.unava.dia.dotapedia2reborn.ui.dotabuff.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.data.heroes.Hero
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
    var mapResult: MutableLiveData<HashMap<Int, String>> = MutableLiveData()

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
                    val successHeroesResult = response.body()
                    if (successHeroesResult != null) {
                        //regen(successHeroesResult)
                        matchesResult.postValue(successHeroesResult)
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
                    val successHeroesResult = response.body()
                    if (successHeroesResult != null) {
                        regen(successHeroesResult)
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun regen(heroes: ArrayList<HeroInfo>) {
        val heroesMap: HashMap<Int, String> = HashMap()

        heroes.withIndex().forEach { (_, temp: HeroInfo) ->
            heroesMap[temp.heroId!!] = temp.name!!
        }
        mapResult.postValue(heroesMap)
    }
}