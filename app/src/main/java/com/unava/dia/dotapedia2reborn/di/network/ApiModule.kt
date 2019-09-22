package com.unava.dia.dotapedia2reborn.di.network

import com.unava.dia.dotapedia2reborn.data.api.DotapediaApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    @Named("openApi")
    fun provideOpenApi (@Named("openApiRetrofit") retrofit: Retrofit) : DotapediaApi {
        return retrofit.create(DotapediaApi::class.java)
    }

    @Provides
    @Singleton
    @Named("steamApi")
    fun provideSteamApi (@Named("steamRetrofit") retrofit: Retrofit) : DotapediaApi {
        return retrofit.create(DotapediaApi::class.java)
    }
}