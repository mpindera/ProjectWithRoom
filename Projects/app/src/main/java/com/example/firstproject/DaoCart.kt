package com.example.firstproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoCart {
    @Query("Select * From DataCart")
    fun getAllLiveData(): LiveData<List<DataCart>>

    @Query("SELECT * FROM DataCart WHERE id IN (:dataCart)")
    fun loadAllByIds(dataCart: IntArray): List<DataCart>

    @Insert
    fun insertData(dataCart: DataCart)

    @Delete
    fun deleteData(dataCart: DataCart)

}