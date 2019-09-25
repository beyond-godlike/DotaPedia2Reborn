package com.unava.dia.dotapedia2reborn.data.articles

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.unava.dia.dotapedia2reborn.data.updates.UpdatesParser
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
                // prepopulate the database after onCreate was called
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        // insert the data on the IO Thread
                        ioThread {
                            val html = UpdatesParser.loadHtml()
                            val updatesList = UpdatesParser.parseHtml(html)
                            getInstance(context).updatesDao().insertAll(updatesList!!)
                        }
                    }

                    fun ioThread(f : () -> Unit) {
                        Executors.newSingleThreadExecutor().execute(f)
                    }
                })
                .build()
    }
}