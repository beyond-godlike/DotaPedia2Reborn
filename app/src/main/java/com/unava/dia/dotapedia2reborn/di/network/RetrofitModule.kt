package com.unava.dia.dotapedia2reborn.di.network

import com.unava.dia.dotapedia2reborn.BuildConfig
import com.unava.dia.dotapedia2reborn.data.api.RetrofitFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class RetrofitModule {
    @Provides
    @Singleton
    @Named("openApiRetrofit")
    fun provideOpenApiRetrofit(): Retrofit {
        return RetrofitFactory.retrofit(BuildConfig.OPENAPI_URL)
    }

    @Provides
    @Singleton
    @Named("steamRetrofit")
    fun provideSteamRetrofit(): Retrofit {
        return RetrofitFactory.retrofit(BuildConfig.STEAM_URL)
    }
}