package com.unava.dia.dotapedia2reborn.data.api

import com.unava.dia.dotapedia2reborn.data.mmrChecker.AccInformation
import com.unava.dia.dotapedia2reborn.domain.useCases.CheckMmrUseCase
import retrofit2.Response

class CheckMmrNetworkUseCase(private val api: DotapediaApi) : CheckMmrUseCase {
    override suspend fun getPlayerInfoAsync(id: String): Response<AccInformation> {
        return api.getPlayerInfo(id)
    }
}