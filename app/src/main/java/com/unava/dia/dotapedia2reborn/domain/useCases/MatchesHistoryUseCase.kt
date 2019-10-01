package com.unava.dia.dotapedia2reborn.domain.useCases

import com.unava.dia.dotapedia2reborn.data.history.HeroInfo
import com.unava.dia.dotapedia2reborn.data.history.HistoryMatch
import retrofit2.Response

interface MatchesHistoryUseCase {
    suspend fun getMatchesHistoryAsync(id: String): Response<ArrayList<HistoryMatch>>

    suspend fun getHeroesInfoAsync(): Response<ArrayList<HeroInfo>>
}