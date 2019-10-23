package com.unava.dia.dotapedia2reborn.data.history

import com.fasterxml.jackson.annotation.JsonProperty

data class HeroInfo(
    @JsonProperty("id")
    var heroId: Int? = null,

    @JsonProperty("name")
    var name: String? = null,

    @JsonProperty("localized_name")
    var localizedName: String? = null,

    @JsonProperty("primary_attr")
    var primaryAttr: String? = null,

    @JsonProperty("attack_type")
    var attackType: String? = null,

    @JsonProperty("roles")
    var roles: ArrayList<String>? = null,

    @JsonProperty("legs")
    var legs: Int? = null
)