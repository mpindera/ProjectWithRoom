package com.example.firstproject

import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
@Composable
fun HomeScreen(navController: NavController) {

    val viewModel: CartViewModel = viewModel()


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        val carts by viewModel.cart.observeAsState()
        CartList(carts = carts ?: emptyList())

    }
}


@Composable
fun CartList(carts: List<DataCart>) {
    LazyColumn {
        items(carts) { cart ->
            Text(text = cart.name ?: "")
        }
    }
}