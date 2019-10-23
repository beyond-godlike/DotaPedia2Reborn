package com.unava.dia.dotapedia2reborn.data.match

import com.fasterxml.jackson.annotation.JsonProperty

data class Player(
    @JsonProperty("result")
    var match: Match? = null
)