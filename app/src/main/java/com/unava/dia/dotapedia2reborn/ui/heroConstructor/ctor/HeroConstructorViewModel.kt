package com.unava.dia.dotapedia2reborn.ui.heroConstructor.ctor

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.data.DotaHero
import com.unava.dia.dotapedia2reborn.data.DotaHeroDao
import io.realm.RealmResults
import javax.inject.Inject

class HeroConstructorViewModel @Inject constructor(
    private val context: Context,
    private val model: HeroConstructorModel
) : ViewModel() {
    private val heroes: MutableLiveData<RealmResults<DotaHero>> = MutableLiveData()
    var hero: MutableLiveData<DotaHero> = MutableLiveData()
    var skillDescription: MutableLiveData<String> = MutableLiveData()

    private var lvl = 1
    private var tempHero: DotaHero = DotaHero()

    private fun loadHeroes() {
        val dotaHeroDao = DotaHeroDao(this.context)
        dotaHeroDao.initRepos()
        heroes.value = dotaHeroDao.loadRepos()
    }

    fun loadHero(id: Int) {
        loadHeroes()
        hero.value = this.heroes.value?.get(id)
        tempHero = hero.value!!
    }

    fun updateLvl() {
        hero.value?.currentLvl = lvl - 1

        when(hero.value?.type) {
            1 -> changeStatsStrength()
            2 -> changeStatsAgility()
            3 -> changeStatsIntelligence()
        }

        hero.value = tempHero
    }

    private fun changeStatsStrength() {
        tempHero.currentStrength = tempHero.strength + tempHero.currentLvl * tempHero.addSt
        tempHero.currentAgility = tempHero.agility + tempHero.currentLvl * tempHero.addAg
        tempHero.currentIntelligence = tempHero.intelligence + tempHero.currentLvl * tempHero.addInt

        tempHero.currentDmg1 = (tempHero.currentLvl * tempHero.addSt) + tempHero.baseDamage1 + tempHero.strength
        tempHero.currentDmg2 = (tempHero.currentLvl * tempHero.addSt) + tempHero.baseDamage2 + tempHero.strength

        tempHero.currentArmor = tempHero.physarmor + (tempHero.currentAgility * 0.16)
        tempHero.currentMagResist = 0.25

        tempHero.currentSpeed = (tempHero.speed + (tempHero.currentAgility * 0.05)).toInt()

        tempHero.currentStrength = tempHero.strength + tempHero.currentLvl * tempHero.addSt
        tempHero.currentHp = tempHero.baseHp + (tempHero.currentStrength * 22.5)

        tempHero.currentIntelligence = tempHero.intelligence + tempHero.currentLvl *tempHero.addInt
        tempHero.currentMp = tempHero.baseMp + (tempHero.currentIntelligence * 12.0)

        tempHero.currentEHP = tempHero.currentHp * (tempHero.currentArmor * 0.06 + 1)
        tempHero.currentEHPm = tempHero.currentHp / (1 - tempHero.currentMagResist)
    }

    private fun changeStatsAgility() {

    }

    private fun changeStatsIntelligence() {

    }


    fun addLvl() {
        if (lvl >= 25) {lvl = 25}
        else {lvl++}
        updateLvl()
    }

    fun minusLvl() {
        if (lvl <= 1) {lvl = 1}
        else {lvl--}
        updateLvl()
    }

    fun maxLvl() {
        lvl = 25
        updateLvl()
    }

    fun resetLvl() {
        lvl = 1
        updateLvl()
    }

    fun updateSkillDescription(id: Int) {
        when(id) {
            1 -> skillDescription.value = hero.value!!.aboutSkill1
            2 -> skillDescription.value = hero.value!!.aboutSkill2
            3 -> skillDescription.value = hero.value!!.aboutSkill3
            4 -> skillDescription.value = hero.value!!.aboutSkill4
            5 -> skillDescription.value = hero.value!!.aboutSkill5
            6 -> skillDescription.value = hero.value!!.aboutSkill6
        }
    }
}