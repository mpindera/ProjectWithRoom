package com.example.firstproject.Room.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DaoCart {
    @Query("Select * From DataCart")
    fun getAllLiveData(): LiveData<List<DataCart>>

    @Query("SELECT * FROM DataCart WHERE id IN (:dataCart)")
    fun loadAllByIds(dataCart: IntArray): List<DataCart>

    @Insert
    suspend fun insertData(dataCart: DataCart)

    @Delete
    suspend fun deleteData(dataCart: DataCart)

    @Update
    suspend fun updateData(dataCart: DataCart)
}