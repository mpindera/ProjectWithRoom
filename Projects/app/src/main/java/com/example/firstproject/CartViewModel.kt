package com.example.firstproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(application: Application) : AndroidViewModel(application) {

    private val daoCart: DaoCart

    val cart: LiveData<List<DataCart>>

    init {
        val database = AppDatabase.getInstance(application)
        daoCart = database.DaoCart()
        cart = daoCart.getAllLiveData()
    }

    fun insertCart(cart: DataCart) {
        viewModelScope.launch(Dispatchers.IO) {
            daoCart.insertData(cart)
        }
    }

    fun deleteCart(cart: DataCart) {
        viewModelScope.launch(Dispatchers.IO) {
            daoCart.deleteData(cart)
        }
    }
}
