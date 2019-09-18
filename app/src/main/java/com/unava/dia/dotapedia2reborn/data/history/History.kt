package com.unava.dia.dotapedia2reborn.data.history

data class History (var status: Int? = null,
                    var numResults: Int? = null,
                    var totalResults: Int? = null,
                    var resultsRemaining: Int? = null,
                    var matches: ArrayList<MatchOfHistory>? = null
)