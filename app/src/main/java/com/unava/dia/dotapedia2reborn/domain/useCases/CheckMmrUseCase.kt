package com.unava.dia.dotapedia2reborn.domain.useCases

import com.unava.dia.dotapedia2reborn.data.mmrChecker.AccInformation
import retrofit2.Response

interface CheckMmrUseCase {
    suspend fun getPlayerInfoAsync(id: String): Response<AccInformation>
}