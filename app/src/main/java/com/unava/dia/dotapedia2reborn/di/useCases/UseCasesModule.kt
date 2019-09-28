package com.unava.dia.dotapedia2reborn.di.useCases

import com.unava.dia.dotapedia2reborn.data.api.CheckMmrNetworkUseCase
import com.unava.dia.dotapedia2reborn.data.api.DotapediaApi
import com.unava.dia.dotapedia2reborn.data.api.OneMatchNetworkUseCase
import com.unava.dia.dotapedia2reborn.domain.useCases.CheckMmrUseCase
import com.unava.dia.dotapedia2reborn.domain.useCases.OneMatchUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class UseCasesModule {
    @Singleton
    @Provides
    fun provideOneMatchUseCase( @Named("steamApi") api: DotapediaApi): OneMatchUseCase {
        return OneMatchNetworkUseCase(api)
    }

    @Singleton
    @Provides
    fun provideCheckMmrUseCase( @Named("openApi") api: DotapediaApi): CheckMmrUseCase {
        return CheckMmrNetworkUseCase(api)
    }
}