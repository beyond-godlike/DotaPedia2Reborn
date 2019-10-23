package com.unava.dia.dotapedia2reborn.domain.useCases

import com.unava.dia.dotapedia2reborn.data.mmrChecker.AccInformation
import retrofit2.Response

interface PlayerInfoUseCase {
    suspend fun getPlayerInfoAsync(id: String): Response<AccInformation>
}