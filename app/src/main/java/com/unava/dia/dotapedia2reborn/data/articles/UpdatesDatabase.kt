package com.unava.dia.dotapedia2reborn.data.articles

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executors

@Database(entities = [UpdatesEntity::class], version = 1)
abstract class UpdatesDatabase : RoomDatabase() {
    abstract fun updatesDao() : UpdatesDao

    companion object {
        @Volatile private var INSTANCE: UpdatesDatabase? = null

        fun getInstance(context: Context): UpdatesDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                UpdatesDatabase::class.java, "updates.db")
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        ioThread {
                            val html = UpdatesParser.loadHtml()
                            val updatesList = UpdatesParser.parseHtml(html)
                            updatesList?.forEach {
                                getInstance(context).updatesDao().insertUpdate(it)
                            }
                        }
                    }

                    fun ioThread(f : () -> Unit) {
                        Executors.newSingleThreadExecutor().execute(f)
                    }
                })
                .build()
    }
}