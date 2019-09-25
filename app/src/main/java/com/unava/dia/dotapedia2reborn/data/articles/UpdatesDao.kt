package com.unava.dia.dotapedia2reborn.data.articles

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface UpdatesDao {
    @Query("SELECT * FROM updates")
    fun loadUpdates() : LiveData<List<UpdatesEntity>>

    @Insert(onConflict = REPLACE)
    @JvmSuppressWildcards
    fun insertAll(updates: List<UpdatesEntity>)

    @Query("DELETE from updates")
    fun deleteAll()
}