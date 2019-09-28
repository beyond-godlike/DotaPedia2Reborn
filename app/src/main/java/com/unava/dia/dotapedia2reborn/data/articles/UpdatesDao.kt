package com.unava.dia.dotapedia2reborn.data.articles

import androidx.room.*

@Dao
interface UpdatesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUpdate(update: UpdatesEntity)

    @Update
    fun updateUpdate(update: UpdatesEntity)

    @Delete
    fun deleteUpdate(update: UpdatesEntity)

    @Query("SELECT * FROM updates")
    fun getUpdates(): List<UpdatesEntity>

//    @Query("SELECT * FROM updates")
//    fun loadUpdates() : LiveData<List<UpdatesEntity>>
//
//    @Insert(onConflict = REPLACE)
//    @JvmSuppressWildcards
//    fun insertAll(updates: List<UpdatesEntity>)

//    @Query("DELETE from updates")
//    fun deleteAll()
}