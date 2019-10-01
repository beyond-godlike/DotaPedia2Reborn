package com.unava.dia.dotapedia2reborn.data.match

import com.fasterxml.jackson.annotation.JsonProperty

data class Result(
    @JsonProperty("account_id")
    var accountId: Float? = null,

    @JsonProperty("player_slot")
    var playerSlot: Int? = null,

    @JsonProperty("hero_id")
    var heroId: Int? = null,

    @JsonProperty("item_0")
    var item0: Int? = null,

    @JsonProperty("item_1")
    var item1: Int? = null,

    @JsonProperty("item_2")
    var item2: Int? = null,

    @JsonProperty("item_3")
    var item3: Int? = null,

    @JsonProperty("item_4")
    var item4: Int? = null,

    @JsonProperty("item_5")
    var item5: Int? = null,

    @JsonProperty("backpack_0")
    var backpack0: Int? = null,

    @JsonProperty("backpack_1")
    var backpack1: Int? = null,

    @JsonProperty("backpack_2")
    var backpack2: Int? = null,

    @JsonProperty("kills")
    var kills: Int? = null,

    @JsonProperty("deaths")
    var deaths: Int? = null,

    @JsonProperty("assists")
    var assists: Int? = null,

    @JsonProperty("leaver_status")
    var leaverStatus: Int? = null,

    @JsonProperty("last_hits")
    var lastHits: Int? = null,

    @JsonProperty("denies")
    var denies: Int? = null,

    @JsonProperty("gold_per_min")
    var gpm: Int? = null,

    @JsonProperty("xp_per_min")
    var xpm: Int? = null,

    @JsonProperty("level")
    var level: Int? = null,

    @JsonProperty("hero_damage")
    var heroDamage: Int? = null,

    @JsonProperty("tower_damage")
    var towerDamage: Int? = null,

    @JsonProperty("hero_healing")
    var heroHealing: Int? = null,

    @JsonProperty("gold")
    var gold: Int? = null,

    @JsonProperty("gold_spent")
    var goldSpent: Int? = null,

    @JsonProperty("scaled_hero_damage")
    var scaledHeroDamage: Int? = null,

    @JsonProperty("scaled_tower_damage")
    var scaledTowerDamage: Int? = null,

    @JsonProperty("scaled_hero_healing")
    var scaledHeroHealing: Int? = null,

    @JsonProperty("ability_upgrades")
    var abilityUpgrades: Any? = null
)