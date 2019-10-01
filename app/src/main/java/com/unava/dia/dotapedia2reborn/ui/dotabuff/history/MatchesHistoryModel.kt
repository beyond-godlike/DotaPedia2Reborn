package com.unava.dia.dotapedia2reborn.ui.dotabuff.history

import com.unava.dia.dotapedia2reborn.data.history.HeroInfo
import com.unava.dia.dotapedia2reborn.data.history.HistoryMatch
import com.unava.dia.dotapedia2reborn.domain.useCases.MatchesHistoryUseCase
import retrofit2.Response
import javax.inject.Inject

class MatchesHistoryModel @Inject constructor(private var useCase: MatchesHistoryUseCase) {
    suspend fun getMatchesAsync(id: String): Response<ArrayList<HistoryMatch>> {
        return this.useCase.getMatchesHistoryAsync(id)
    }

    suspend fun getHeroesInfoAsync(): Response<ArrayList<HeroInfo>> {
        return this.useCase.getHeroesInfoAsync()
    }
}