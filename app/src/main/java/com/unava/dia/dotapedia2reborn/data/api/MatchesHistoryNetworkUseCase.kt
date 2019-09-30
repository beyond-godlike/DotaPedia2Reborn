package com.unava.dia.dotapedia2reborn.data.api

import com.unava.dia.dotapedia2reborn.data.history.History
import com.unava.dia.dotapedia2reborn.domain.useCases.MatchesHistoryUseCase
import retrofit2.Response
import javax.inject.Named

class MatchesHistoryNetworkUseCase(@Named("steamApi")private val api: DotapediaApi) : MatchesHistoryUseCase {
    override suspend fun getMatchesHistoryAsync(id: String, KEY: String): Response<History> {
        return api.getHistory(id, KEY)
    }

}