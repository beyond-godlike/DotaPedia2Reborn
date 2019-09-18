package com.unava.dia.dotapedia2reborn.ui.dotabuff.match

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.data.heroes.Hero
import com.unava.dia.dotapedia2reborn.data.heroes.Heroes
import com.unava.dia.dotapedia2reborn.data.match.Player
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MatchViewModel @Inject constructor(private val model: MatchModel) : ViewModel() {
    val oneMatchResult: MutableLiveData<Boolean> = MutableLiveData()
    val oneMatchErrorSubject: MutableLiveData<String> = MutableLiveData()

    var matchResult: MutableLiveData<Player> = MutableLiveData()
    var mapResult: MutableLiveData<HashMap<Int, String>> = MutableLiveData()

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    private fun getHeroes(KEY: String) {
        scope.launch {
            try {
                val response = model.getHeroesAsync(KEY)
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

    fun getMatch(matchId: String, KEY: String) {
        getHeroes(KEY)

        scope.launch {
            try {
                val response = model.getOneMatchAsync(matchId, KEY)
                if (response.isSuccessful) {
                    val successMatchResult = response.body()
                    if (successMatchResult != null) {
                        matchResult.postValue(successMatchResult)
                        oneMatchResult.postValue(true)
                    } else {
                        oneMatchResult.postValue(false)
                    }
                } else {
                    oneMatchErrorSubject.postValue(response.errorBody().toString())
                }
            } catch (e: Exception) {
                e.printStackTrace()
                oneMatchErrorSubject.postValue(e.localizedMessage)
            }
        }
    }

    private fun regen(heroes: Heroes) {
        val heroesMap: HashMap<Int, String> = HashMap()

        heroes.result!!.heroes!!.withIndex().forEach { (_, temp: Hero) ->
            heroesMap[temp.id!!] = temp.name!!
        }
        mapResult.postValue(heroesMap)
    }


    fun cancelAllRequests() = coroutineContext.cancel()
}