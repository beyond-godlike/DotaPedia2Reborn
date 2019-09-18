package com.unava.dia.dotapedia2reborn.domain.useCases

import com.unava.dia.dotapedia2reborn.data.heroes.Heroes
import com.unava.dia.dotapedia2reborn.data.match.Player
import retrofit2.Response

interface OneMatchUseCase {
    suspend fun getOneMatchAsync(accId: String, KEY: String): Response<Player>

    suspend fun getHeroesAsync(KEY: String) : Response<Heroes>
}