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

    private var tempHero: DotaHero = DotaHero()

    fun loadHeroes() {
        val dotaHeroDao = DotaHeroDao(this.context)
        dotaHeroDao.initRepos()
        heroes.value = dotaHeroDao.loadRepos()
    }

    fun loadHero(id: Int) {
        hero.value = this.heroes.value?.get(id)
        tempHero = hero.value!!
    }

}