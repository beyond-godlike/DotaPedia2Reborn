package com.unava.dia.dotapedia2reborn.ui.heroConstructor.ctor

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.data.DotaHero
import com.unava.dia.dotapedia2reborn.data.DotaHeroDao
import com.unava.dia.dotapedia2reborn.data.Invoker
import io.realm.RealmResults
import javax.inject.Inject

class HeroConstructorViewModel @Inject constructor(
    private val context: Context,
    private val model: HeroConstructorModel
) : ViewModel() {
    private val heroes: MutableLiveData<RealmResults<DotaHero>> = MutableLiveData()
    var hero: MutableLiveData<DotaHero> = MutableLiveData()
    var skillDescription: MutableLiveData<String> = MutableLiveData()
    var invoker: MutableLiveData<Invoker> = MutableLiveData()

    private var lvl = 1
    private var tempHero: DotaHero = DotaHero()
    private var tempInvoker = Invoker()

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

    // TODO replace into model
    private fun changeStatsStrength() {
        tempHero.currentStrength = tempHero.base_str + tempHero.currentLvl * tempHero.str_gain
        tempHero.currentAgility = tempHero.base_agi + tempHero.currentLvl * tempHero.agi_gain
        tempHero.currentIntelligence = tempHero.base_int+ tempHero.currentLvl * tempHero.int_gain

        tempHero.currentDmg1 = (tempHero.currentLvl * tempHero.str_gain) + tempHero.base_attack_min + tempHero.base_str
        tempHero.currentDmg2 = (tempHero.currentLvl * tempHero.str_gain) + tempHero.base_attack_max + tempHero.base_str

        tempHero.currentArmor = tempHero.base_armor + (tempHero.currentAgility * 0.16)
        tempHero.currentMagResist = 0.25

        tempHero.currentSpeed = (tempHero.move_speed + (tempHero.currentAgility * 0.05)).toInt()

        tempHero.currentStrength = tempHero.base_str + tempHero.currentLvl * tempHero.str_gain
        tempHero.currentHp = tempHero.base_health + (tempHero.currentStrength * 22.5)

        tempHero.currentIntelligence = tempHero.base_int + tempHero.currentLvl *tempHero.int_gain
        tempHero.currentMp = tempHero.base_mana + (tempHero.currentIntelligence * 12.0)

        tempHero.currentEHP = tempHero.currentHp * (tempHero.currentArmor * 0.06 + 1)
        tempHero.currentEHPm = tempHero.currentHp / (1 - tempHero.currentMagResist)
    }

    private fun changeStatsAgility() {
        tempHero.currentStrength = tempHero.base_str + tempHero.currentLvl * tempHero.str_gain
        tempHero.currentAgility = tempHero.base_agi + tempHero.currentLvl * tempHero.agi_gain
        tempHero.currentIntelligence = tempHero.base_int + tempHero.currentLvl * tempHero.int_gain

        tempHero.currentDmg1 = (tempHero.currentLvl * tempHero.agi_gain) + tempHero.base_attack_min + tempHero.base_agi
        tempHero.currentDmg2 = (tempHero.currentLvl * tempHero.agi_gain) + tempHero.base_attack_max + tempHero.base_agi

        tempHero.currentArmor = tempHero.base_armor + (tempHero.currentAgility * 0.2)
        tempHero.currentMagResist = 0.25

        tempHero.currentSpeed = (tempHero.move_speed + (tempHero.currentAgility * 0.063)).toInt()

        tempHero.currentStrength = tempHero.base_str + tempHero.currentLvl * tempHero.agi_gain
        tempHero.currentHp = tempHero.base_health + (tempHero.currentStrength * 18)

        tempHero.currentIntelligence = tempHero.base_int + tempHero.currentLvl * tempHero.int_gain
        tempHero.currentMp = tempHero.base_mana + (tempHero.currentIntelligence * 12.0)

        tempHero.currentEHP = tempHero.currentHp * (tempHero.currentArmor * 0.06 + 1)
        tempHero.currentEHPm = tempHero.currentHp / (1 - tempHero.currentMagResist)
    }

    private fun changeStatsIntelligence() {
        tempHero.currentStrength = tempHero.base_str + tempHero.currentLvl * tempHero.str_gain
        tempHero.currentAgility = tempHero.base_agi + tempHero.currentLvl * tempHero.agi_gain
        tempHero.currentIntelligence = tempHero.base_int + tempHero.currentLvl * tempHero.int_gain

        tempHero.currentDmg1 = (tempHero.currentLvl * tempHero.int_gain) + tempHero.base_attack_min + tempHero.base_int
        tempHero.currentDmg2 = (tempHero.currentLvl * tempHero.int_gain) + tempHero.base_attack_max + tempHero.base_int

        tempHero.currentArmor = tempHero.base_armor + (tempHero.currentAgility * 0.16)
        tempHero.currentMagResist = 0.25

        tempHero.currentSpeed = (tempHero.move_speed + (tempHero.currentAgility * 0.05)).toInt()

        tempHero.currentStrength = tempHero.base_str + tempHero.currentLvl * tempHero.str_gain
        tempHero.currentHp = tempHero.base_health + (tempHero.currentStrength * 18)

        tempHero.currentIntelligence = tempHero.base_int + tempHero.currentLvl * tempHero.int_gain
        tempHero.currentMp = tempHero.base_mana + (tempHero.currentIntelligence * 15.0)

        tempHero.currentEHP = tempHero.currentHp * (tempHero.currentArmor * 0.06 + 1)
        tempHero.currentEHPm = tempHero.currentHp / (1 - tempHero.currentMagResist)

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
            1 -> {
                skillDescription.value = hero.value!!.aboutSkill1
                if(isInvoker(hero.value!!.name)) {
                    tempInvoker.pushEnd("q")
                }
            }
            2 -> {
                skillDescription.value = hero.value!!.aboutSkill2
                if(isInvoker(hero.value!!.name)) {
                    tempInvoker.pushEnd("w")
                }
            }
            3 -> {
                skillDescription.value = hero.value!!.aboutSkill3
                if(isInvoker(hero.value!!.name)) {
                    tempInvoker.pushEnd("e")
                }
            }
            4 -> skillDescription.value = hero.value!!.aboutSkill4
            5 -> skillDescription.value = hero.value!!.aboutSkill5
            6 -> {
                skillDescription.value = hero.value!!.aboutSkill6
                tempInvoker.generatePath()
                invoker.value = tempInvoker
            }
        }
    }

    private fun isInvoker(name: String) : Boolean {
        return name == "Invoker"
    }
}