package com.unava.dia.dotapedia2reborn.ui.heroConstructor.picker

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.data.DotaHero
import com.unava.dia.dotapedia2reborn.data.DotaHeroDao
import io.realm.RealmResults
import javax.inject.Inject

class HeroPickerViewModel @Inject constructor(
    private val context: Context,
    private val model: HeroPickerModel
) : ViewModel() {
    var heroes: MutableLiveData<RealmResults<DotaHero>> = MutableLiveData()

    fun loadHeroes() {
        val dotaHeroDao = DotaHeroDao(this.context)
        dotaHeroDao.initRepos()
        heroes.value = dotaHeroDao.loadRepos()
    }
}