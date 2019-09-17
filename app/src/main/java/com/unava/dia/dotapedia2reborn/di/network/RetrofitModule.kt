package com.unava.dia.dotapedia2reborn.di.network

import com.unava.dia.dotapedia2reborn.data.api.RetrofitFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RetrofitModule {
    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return RetrofitFactory.retrofit()
    }
}