package com.unava.dia.dotapedia2reborn.data.history

import com.fasterxml.jackson.annotation.JsonProperty

data class History(
    @JsonProperty("result")
    var match: Result? = null
)