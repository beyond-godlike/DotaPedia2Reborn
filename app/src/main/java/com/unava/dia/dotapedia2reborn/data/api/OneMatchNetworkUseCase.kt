package com.unava.dia.dotapedia2reborn.data.api

import com.unava.dia.dotapedia2reborn.data.heroes.Heroes
import com.unava.dia.dotapedia2reborn.data.match.Player
import com.unava.dia.dotapedia2reborn.domain.useCases.OneMatchUseCase
import retrofit2.Response

class OneMatchNetworkUseCase(private val api: DotapediaApi) : OneMatchUseCase {
    override suspend fun getHeroesAsync(KEY: String): Response<Heroes> {
        return api.getHeroes(KEY)
    }

    override suspend fun getOneMatchAsync(accId: String, KEY: String): Response<Player> {
        return api.getOneMatch(accId, KEY)
    }
}