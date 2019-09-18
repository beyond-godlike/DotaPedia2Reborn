package com.unava.dia.dotapedia2reborn.data.mmrChecker

import com.fasterxml.jackson.annotation.JsonProperty

data class MmrEstimate(
    @JsonProperty("estimate")
    var estimate: Int? = null,

    @JsonProperty("std_dev")
    var std_dev: Int? = null,

    @JsonProperty("n")
    var n: Int? = null
)