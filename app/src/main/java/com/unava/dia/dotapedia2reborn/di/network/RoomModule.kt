package com.unava.dia.dotapedia2reborn.di.network

import android.app.Application
import com.unava.dia.dotapedia2reborn.data.articles.UpdatesDao
import com.unava.dia.dotapedia2reborn.data.articles.UpdatesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Provides
    @Singleton
    fun provideUpdatesDatabase(application: Application) : UpdatesDatabase {
        return UpdatesDatabase.getInstance(application)
    }

    @Provides
    @Singleton
    fun provideUpdatesDao(updatesDatabase : UpdatesDatabase) : UpdatesDao {
        return updatesDatabase.updatesDao()
    }
}