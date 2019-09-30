package com.unava.dia.dotapedia2reborn.domain.useCases

import com.unava.dia.dotapedia2reborn.data.history.History
import retrofit2.Response

interface MatchesHistoryUseCase {
    suspend fun getMatchesHistoryAsync(id: String, KEY: String): Response<History>
}