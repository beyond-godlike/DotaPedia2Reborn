package com.unava.dia.dotapedia2reborn.data

import io.realm.RealmObject
import io.realm.annotations.Ignore

open class DotaHero : RealmObject() {
    open var name: String = ""
    open var rname: String = ""
    open var type: Int = 1
    open var icon: String = ""
    open var ultimateLvlUnlock: Int = 1
    open var strength: Double = 0.0
    open var agility: Double = 0.0
    open var intelligence: Double = 0.0
    open var addSt: Double = 0.0
    open var addAg: Double = 0.0
    open var addInt: Double = 0.0
    open var baseDamage1: Double = 0.0
    open var baseDamage2: Double = 0.0
    open var physarmor: Double = 0.0
    open var speed: Int = 0
    open var attackType: String = ""
    open var range: Int = 0
    open var baseHp: Double = 0.0
    open var baseMp: Double = 0.0
    open var aboutSkill1: String = ""
    open var aboutSkill2: String = ""
    open var aboutSkill3: String = ""
    open var aboutSkill4: String = ""
    open var aboutSkill5: String = ""
    open var aboutSkill6: String = ""
    open var talent10: String = ""
    open var talent15: String = ""
    open var talent20: String = ""
    open var talent25: String = ""
    open var skill1: String = ""
    open var skill2: String = ""
    open var skill3: String = ""
    open var skill4: String = ""
    open var skill5: String = ""
    open var skill6: String = ""
    @Ignore
    open var currentLvl: Int = 1
    @Ignore
    open var currentAgility: Double = 0.0
    @Ignore
    open var currentStrength: Double = 0.0
    @Ignore
    open var currentIntelligence: Double = 0.0
    @Ignore
    open var currentHp: Double = 0.0
    @Ignore
    open var currentMp: Double = 0.0
    @Ignore
    open var currentEHP: Double = 0.0
    @Ignore
    open var currentEHPm: Double = 0.0
    @Ignore
    open var currentArmor: Double = 0.0
    @Ignore
    open var currentMagResist: Double = 0.0
    @Ignore
    open var currentDmg1: Double = 0.0
    @Ignore
    open var currentDmg2: Double = 0.0
    @Ignore
    open var currentSpeed: Int = 0
}