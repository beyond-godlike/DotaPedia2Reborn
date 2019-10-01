package com.unava.dia.dotapedia2reborn.data.api

import com.unava.dia.dotapedia2reborn.data.history.HeroInfo
import com.unava.dia.dotapedia2reborn.data.history.HistoryMatch
import com.unava.dia.dotapedia2reborn.domain.useCases.MatchesHistoryUseCase
import retrofit2.Response
import javax.inject.Named

class MatchesHistoryNetworkUseCase(@Named("openApi")private val api: DotapediaApi) : MatchesHistoryUseCase {
    override suspend fun getMatchesHistoryAsync(id: String): Response<ArrayList<HistoryMatch>> {
        return api.getMatchesHistory(id)
    }

    override suspend fun getHeroesInfoAsync(): Response<ArrayList<HeroInfo>> {
        return api.getHeroInfo()
    }

}