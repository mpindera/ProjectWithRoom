package com.example.firstproject

import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstproject.Room.database.CartViewModel
import com.example.firstproject.textfields.TextFieldAddingData
import com.example.firstproject.textfields.TextFieldConfig

@Composable
fun AddDataCart(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            fontSize = 25.sp,
            text = "Enter data",
            modifier = Modifier.padding(bottom = 30.dp)
        )

        val textFields = listOf(
            TextFieldConfig(
                label = "Name",
                focusedBorderColor = Red,
                unfocusedBorderColor = Black,
                textColor = Black
            )
        )

        TextFieldAddingData(textFields = textFields, cartViewModel = CartViewModel(Application()),navController)

    }
}
