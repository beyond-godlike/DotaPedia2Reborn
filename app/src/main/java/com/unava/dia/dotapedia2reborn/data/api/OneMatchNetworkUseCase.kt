package com.unava.dia.dotapedia2reborn.data.api

import com.unava.dia.dotapedia2reborn.data.heroes.Heroes
import com.unava.dia.dotapedia2reborn.data.match.Player
import com.unava.dia.dotapedia2reborn.data.mmrChecker.AccInformation
import com.unava.dia.dotapedia2reborn.domain.useCases.OneMatchUseCase
import retrofit2.Response
import javax.inject.Named

class OneMatchNetworkUseCase(@Named("steamApi")private val api: DotapediaApi) : OneMatchUseCase {
    override suspend fun getHeroesAsync(KEY: String): Response<Heroes> {
        return api.getHeroes(KEY)
    }

    override suspend fun getOneMatchAsync(accId: String, KEY: String): Response<Player> {
        return api.getOneMatch(accId, KEY)
    }

    override suspend fun getPlayerInfoAsync(id: String): Response<AccInformation> {
        return api.getPlayerInfo(id)
    }
}