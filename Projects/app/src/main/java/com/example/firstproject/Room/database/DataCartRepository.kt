package com.example.firstproject.Room.database

import android.provider.ContactsContract.Data
import androidx.lifecycle.LiveData

class DataCartRepository(private val dataCartDatabase: DaoCart) {
    val readAllData : LiveData<List<DataCart>> = dataCartDatabase.getAllLiveData()

    suspend fun addData(addDataCart: DataCart){
        dataCartDatabase.insertData(addDataCart)
    }
    suspend fun deleteData(addDataCart: DataCart){
        dataCartDatabase.deleteData(addDataCart)
    }

    suspend fun updateData(addDataCart: DataCart){
        dataCartDatabase.updateData(addDataCart)
    }
}