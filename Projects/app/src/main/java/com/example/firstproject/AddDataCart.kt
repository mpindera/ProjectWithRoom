package com.example.firstproject

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.stringResource
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
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            fontSize = 25.sp,
            text = stringResource(R.string.enter_data),
            modifier = Modifier.padding(bottom = 30.dp)
        )

        val textFields = listOf(
            TextFieldConfig(
                label = stringResource(R.string.enter),
                focusedBorderColor = Red,
                unfocusedBorderColor = Black,
                textColor = Black
            )
        )
        Card {
            TextFieldAddingData(
                textFields = textFields,
                cartViewModel = CartViewModel(Application()),
                navController
            )
        }


    }
}
