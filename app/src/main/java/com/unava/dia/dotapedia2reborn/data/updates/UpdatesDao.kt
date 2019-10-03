package com.unava.dia.dotapedia2reborn.data.updates

import androidx.room.*

@Dao
interface UpdatesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUpdate(update: UpdatesEntity)

    @Update
    fun updateUpdate(update: UpdatesEntity)

    @Delete
    fun deleteUpdate(update: UpdatesEntity)

    @Query("DELETE FROM updates")
    fun deleteAllUpdates()

    @Query("SELECT * FROM updates")
    fun getUpdates(): List<UpdatesEntity>
}