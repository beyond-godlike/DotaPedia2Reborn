package com.unava.dia.dotapedia2reborn.data.match

import com.fasterxml.jackson.annotation.JsonProperty

data class Match (@JsonProperty("players")
                  var players: ArrayList<Result>? = null,

                  @JsonProperty("radiant_win")
                  var radiantWin: Boolean? = false,

                  @JsonProperty("duration")
                  var duration: Int? = null,

                  @JsonProperty("pre_game_duration")
                  var preGameDuration: Int? = null,

                  @JsonProperty("start_time")
                  var startTime: Float? = null,

                  @JsonProperty("match_id")
                  var matchId: Float? = null,

                  @JsonProperty("match_seq_num")
                  var matchSeqNum: Float? = null,

                  @JsonProperty("tower_status_radiant")
                  var towerStatusRadiant: Int? = null,

                  @JsonProperty("tower_status_dire")
                  var towerStatusDire: Int? = null,

                  @JsonProperty("barracks_status_radiant")
                  var barracksStatusRadiant: Int? = null,

                  @JsonProperty("barracks_status_dire")
                  var barracksStatusDire: Int? = null,

                  @JsonProperty("cluster")
                  var cluster: Int? = null,

                  @JsonProperty("first_blood_time")
                  var firstBloodTime: Int? = null,

                  @JsonProperty("lobby_type")
                  var lobbyType: Int? = null,

                  @JsonProperty("human_players")
                  var humanPlayers: Int? = null,

                  @JsonProperty("leagueid")
                  var leagueid: Int? = null,

                  @JsonProperty("positive_votes")
                  var positiveVotes: Int? = null,

                  @JsonProperty("negative_votes")
                  var negativeVotes: Int? = null,

                  @JsonProperty("game_mode")
                  var gameMode: Int? = null,

                  @JsonProperty("flags")
                  var flags: Int? = null,

                  @JsonProperty("engine")
                  var engine: Int? = null,

                  @JsonProperty("radiant_score")
                  var radiantScore: Int? = null,

                  @JsonProperty("dire_score")
                  var direScore: Int? = null,

                  @JsonProperty("picks_bans")
                  var picksBans: Any? = null
)