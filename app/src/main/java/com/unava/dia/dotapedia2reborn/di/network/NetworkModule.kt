package com.unava.dia.dotapedia2reborn.di.network

import dagger.Module

@Module(includes = [
    RetrofitModule::class,
    ApiModule::class
    // RepositoryModule::class
])
abstract class NetworkModule