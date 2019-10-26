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
        changeStats(hero.value?.type!!)
        hero.value = tempHero
    }

    private fun changeStats(type: Int) {
        tempHero.currentStrength = getStr()
        tempHero.currentAgility = getAgi()
        tempHero.currentIntelligence = getInt()
        tempHero.currentDmg1 = getMinDamage(type)
        tempHero.currentDmg2 = getMaxDamage(type)
        tempHero.currentArmor = getArmor(type)
        tempHero.currentMagResist = getMagResist(type)
        tempHero.currentSpeed = getSpeed(type)
        tempHero.currentHp = getHealth(type)
        tempHero.currentEHP = getPhysEHP()
        tempHero.currentEHPm = getMagicalEHP()
        tempHero.currentMp = getMana(type)
    }

    private fun getStr() : Double {
        return tempHero.base_str + tempHero.currentLvl * tempHero.str_gain
    }

    private fun getAgi() : Double {
        return tempHero.base_agi + tempHero.currentLvl * tempHero.agi_gain
    }

    private fun getInt() : Double {
        return tempHero.base_int+ tempHero.currentLvl * tempHero.int_gain
    }

    private fun getMinDamage(type: Int) : Double {
        return when(type) {
            1 -> (tempHero.currentLvl * tempHero.str_gain) + tempHero.base_attack_min + tempHero.base_str
            2 -> (tempHero.currentLvl * tempHero.agi_gain) + tempHero.base_attack_min + tempHero.base_agi
            3 -> (tempHero.currentLvl * tempHero.int_gain) + tempHero.base_attack_min + tempHero.base_int
            else -> return 0.0
        }
    }

    private fun getMaxDamage(type: Int) : Double {
        return when(type) {
            1 -> (tempHero.currentLvl * tempHero.str_gain) + tempHero.base_attack_max + tempHero.base_str
            2 -> (tempHero.currentLvl * tempHero.agi_gain) + tempHero.base_attack_max + tempHero.base_agi
            3 -> (tempHero.currentLvl * tempHero.int_gain) + tempHero.base_attack_max + tempHero.base_int
            else -> return 0.0
        }
    }

    private fun getArmor(type: Int) : Double {
        return when(type) {
            2 -> tempHero.base_armor + (tempHero.currentAgility * 0.2)
            else -> tempHero.base_armor + (tempHero.currentAgility * 0.16)
        }
    }

    // TODO change resist for strength. find formula
    private fun getMagResist(type: Int) : Double {
        return when(type) {
            1 -> 0.25
            else -> 0.25
        }
    }

    private fun getSpeed(type: Int) : Int {
        return when(type) {
            2 ->  (tempHero.move_speed + (tempHero.currentAgility * 0.063)).toInt()
            else ->  (tempHero.move_speed + (tempHero.currentAgility * 0.05)).toInt()
        }
    }

    private fun getHealth(type: Int) : Double {
        return when(type) {
            1 -> tempHero.base_health + (tempHero.currentStrength * 22.5)
            else -> tempHero.base_health + (tempHero.currentStrength * 18)
        }
    }

    private fun getPhysEHP() : Double {
        return  tempHero.currentHp * (tempHero.currentArmor * 0.06 + 1)
    }

    private fun getMagicalEHP() : Double {
        return tempHero.currentHp / (1 - tempHero.currentMagResist)
    }
    private fun getMana (type: Int) : Double {
        return when(type) {
            3 -> tempHero.base_mana + (tempHero.currentIntelligence * 15.0)
            else -> tempHero.base_mana + (tempHero.currentIntelligence * 12.0)
        }
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