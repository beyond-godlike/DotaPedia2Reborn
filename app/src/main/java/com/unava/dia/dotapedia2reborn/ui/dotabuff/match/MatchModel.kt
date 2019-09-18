package com.unava.dia.dotapedia2reborn.ui.dotabuff.match

import com.unava.dia.dotapedia2reborn.data.heroes.Heroes
import com.unava.dia.dotapedia2reborn.data.match.Player
import com.unava.dia.dotapedia2reborn.domain.useCases.OneMatchUseCase
import retrofit2.Response
import javax.inject.Inject

class MatchModel @Inject constructor(private var useCase: OneMatchUseCase) {
    suspend fun getOneMatchAsync(matchId: String, KEY: String): Response<Player> {
        return this.useCase.getOneMatchAsync(matchId, KEY)
    }

    suspend fun getHeroesAsync(KEY: String) : Response<Heroes> {
        return this.useCase.getHeroesAsync(KEY)
    }
}