package com.unava.dia.dotapedia2reborn.di.network

import com.unava.dia.dotapedia2reborn.data.api.DotapediaApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit) : DotapediaApi {
        return retrofit.create(DotapediaApi::class.java)
    }
}