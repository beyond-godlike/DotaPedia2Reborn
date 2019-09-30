package com.unava.dia.dotapedia2reborn.data.history

import com.fasterxml.jackson.annotation.JsonProperty

data class Player(
    @JsonProperty("account_id")
    var accountId: Float? = null,

    @JsonProperty("player_slot")
    var playerSlot: Int? = null,

    @JsonProperty("hero_id")
    var heroId: Int? = null
)