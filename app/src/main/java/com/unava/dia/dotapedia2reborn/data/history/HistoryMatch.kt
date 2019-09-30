package com.unava.dia.dotapedia2reborn.data.history

import com.fasterxml.jackson.annotation.JsonProperty

data class HistoryMatch(
    @JsonProperty("match_id")
    var matchId: Float? = null,

    @JsonProperty("match_seq_num")
    var matchSeqNum: Float? = null,

    @JsonProperty("start_time")
    var startTime: Float? = null,

    @JsonProperty("lobby_type")
    var lobbyType: Int? = null,

    @JsonProperty("radiant_team_id")
    var radiantTeamId: Int? = null,

    @JsonProperty("dire_team_id")
    var direTeamId: Int? = null,

    @JsonProperty("players")
    var players: ArrayList<Player>? = null
)