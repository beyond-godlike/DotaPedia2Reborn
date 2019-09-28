package com.unava.dia.dotapedia2reborn.data.updates

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UpdatesEntity::class], version = 1, exportSchema = true)
abstract class UpdatesDatabase : RoomDatabase() {
    abstract fun updatesDao(): UpdatesDao

    companion object {

        @Volatile
        private var INSTANCE: UpdatesDatabase? = null

        fun getInstance(context: Context): UpdatesDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                UpdatesDatabase::class.java, "updates.db"
            ).build()
    }

    fun destroyDataBase() {
        INSTANCE = null
    }

}