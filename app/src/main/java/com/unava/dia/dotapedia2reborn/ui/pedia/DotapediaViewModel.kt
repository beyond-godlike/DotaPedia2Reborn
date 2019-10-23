package com.unava.dia.dotapedia2reborn.ui.pedia

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.data.DotaHero
import com.unava.dia.dotapedia2reborn.data.DotaHeroDao
import io.realm.RealmResults
import javax.inject.Inject

class DotapediaViewModel @Inject constructor(
    private val context: Context,
    private val model: DotapediaModel
) : ViewModel() {

    val heroes: MutableLiveData<RealmResults<DotaHero>> = MutableLiveData()
    var hero: MutableLiveData<DotaHero> = MutableLiveData()
    var currentHeroId: MutableLiveData<Int> = MutableLiveData()

    init {
        currentHeroId.value = 0
    }

    private var tempHero: DotaHero = DotaHero()

    fun loadHeroes() {
        if (heroes.value.isNullOrEmpty()) {
            val dotaHeroDao = DotaHeroDao(this.context)
            dotaHeroDao.initRepos()
            heroes.value = dotaHeroDao.loadRepos()
        }
    }

    fun loadHero() {
        hero.value = this.heroes.value?.get(currentHeroId.value!!)
        tempHero = hero.value!!
    }

    fun changeCurrentHeroId(id: Int) {
        currentHeroId.value = id
    }

}