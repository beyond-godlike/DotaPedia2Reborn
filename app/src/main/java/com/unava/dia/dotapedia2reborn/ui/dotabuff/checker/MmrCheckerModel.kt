package com.unava.dia.dotapedia2reborn.ui.dotabuff.checker

import com.unava.dia.dotapedia2reborn.data.mmrChecker.AccInformation
import com.unava.dia.dotapedia2reborn.domain.useCases.CheckMmrUseCase
import retrofit2.Response
import javax.inject.Inject
class MmrCheckerModel @Inject constructor(private var useCase: CheckMmrUseCase) {
    suspend fun getPlayerInfoAsync(id: String): Response<AccInformation> {
        return this.useCase.getPlayerInfoAsync(id)
    }
}