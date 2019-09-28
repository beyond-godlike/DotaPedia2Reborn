package com.unava.dia.dotapedia2reborn.di.network

import dagger.Module

@Module(includes = [
    RetrofitModule::class,
    ApiModule::class,
    RoomModule::class
])
abstract class NetworkModule