package com.unava.dia.dotapedia2reborn.data.api

import com.unava.dia.dotapedia2reborn.data.heroes.Heroes
import com.unava.dia.dotapedia2reborn.data.history.HeroInfo
import com.unava.dia.dotapedia2reborn.data.history.HistoryMatch
import com.unava.dia.dotapedia2reborn.data.match.Player
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path
import com.unava.dia.dotapedia2reborn.data.mmrChecker.AccInformation

interface DotapediaApi {
    @GET("IDOTA2Match_570/GetMatchDetails/v1/")
    suspend fun getOneMatch(@Query("match_id") matchId: String,
                            @Query("key")key: String) : Response<Player>

    //@GET("IDOTA2Match_570/GetMatchHistory/V001/")
    //suspend fun getHistory(@Query("account_id") accountId: String,
    //                       @Query("key") key: String) : Response<History>

    @GET("IEconDOTA2_570/GetHeroes/v0001/")
    suspend fun getHeroes(@Query("key") key: String) : Response<Heroes>

    @GET("players/{accountId}")
    suspend fun getPlayerInfo(@Path("accountId") accountId: String): Response<AccInformation>

    @GET("players/{accountId}/matches")
    suspend fun getMatchesHistory(@Path("accountId") accountId: String): Response<ArrayList<HistoryMatch>>

    @GET("heroes")
    suspend fun getHeroInfo(): Response<ArrayList<HeroInfo>>
}