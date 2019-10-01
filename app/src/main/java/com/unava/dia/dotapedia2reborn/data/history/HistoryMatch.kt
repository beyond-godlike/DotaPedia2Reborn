package com.unava.dia.dotapedia2reborn.data.history

import com.fasterxml.jackson.annotation.JsonProperty

data class HistoryMatch(
    @JsonProperty("match_id")
    var matchId: Float? = null,

    @JsonProperty("player_slot")
    var playerSlot: Int? = null,

    @JsonProperty("radiant_win")
    var radiantWin: Boolean? = null,

    @JsonProperty("duration")
    var duration: Long? = null,

    @JsonProperty("game_mode")
    var gameMode: Int? = null,

    @JsonProperty("lobby_type")
    var lobbyType: Int? = null,

    @JsonProperty("hero_id")
    var heroId: Int? = null,

    @JsonProperty("start_time")
    var startTime: Float? = null,

    @JsonProperty("version")
    var version: Int? = null,

    @JsonProperty("kills")
    var kills: Int? = null,

    @JsonProperty("deaths")
    var deaths: Int? = null,

    @JsonProperty("assists")
    var assists: Int? = null,

    @JsonProperty("skill")
    var skill: Int? = null,

    @JsonProperty("leaver_status")
    var leaverStatus: Int? = null,

    @JsonProperty("party_size")
    var partySize: Int? = null
)