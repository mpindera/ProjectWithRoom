package com.example.firstproject.Room.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(application: Application) : AndroidViewModel(application) {

    private val daoCart: DataCartRepository

    val cart: LiveData<List<DataCart>>

    init {
        val database = AppDatabase.getInstance(application).DaoCart()
        daoCart = DataCartRepository(database)
        cart = daoCart.readAllData
    }

    fun insertCart(cart: DataCart) {
        viewModelScope.launch(Dispatchers.IO) {
            daoCart.addData(cart)
        }
    }

    fun deleteCart(cart: DataCart) {
        viewModelScope.launch(Dispatchers.IO) {
            daoCart.deleteData(cart)
        }
    }

    fun updateCart(cart: DataCart) {
        viewModelScope.launch(Dispatchers.IO) {
            daoCart.updateData(cart)
        }
    }
}
