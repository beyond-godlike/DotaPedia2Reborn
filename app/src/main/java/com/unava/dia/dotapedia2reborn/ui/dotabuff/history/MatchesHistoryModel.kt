package com.unava.dia.dotapedia2reborn.ui.dotabuff.history

import com.unava.dia.dotapedia2reborn.data.history.History
import com.unava.dia.dotapedia2reborn.domain.useCases.MatchesHistoryUseCase
import retrofit2.Response
import javax.inject.Inject

class MatchesHistoryModel @Inject constructor(private var useCase: MatchesHistoryUseCase) {
    suspend fun getMatchesAsync(id: String, KEY: String): Response<History> {
        return this.useCase.getMatchesHistoryAsync(id, KEY)
    }
}