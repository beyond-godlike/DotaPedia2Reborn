package com.unava.dia.dotapedia2reborn.data.history

data class MatchOfHistory (var matchId: Int? = null,
                           var matchSeqNum: Int? = null,
                           var matchStartTime: Int? = null,
                           var lobbyType: Int? = null,
                           var radiantTeamId: Int? = null,
                           var direTeamId: Int? = null,
                           var players: ArrayList<PlayerOfHistory>? = null
)