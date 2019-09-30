package com.unava.dia.dotapedia2reborn.data.history

import com.fasterxml.jackson.annotation.JsonProperty

data class Result(
    @JsonProperty("status")
    var status: Int? = null,

    @JsonProperty("num_results")
    var numResults: Int? = null,

    @JsonProperty("total_results")
    var totalResults: Int? = null,

    @JsonProperty("results_remaining")
    var remainingResults: Int? = null,

    @JsonProperty("matches")
    var matches: ArrayList<HistoryMatch>? = null
)