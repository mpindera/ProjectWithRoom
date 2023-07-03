package com.example.firstproject.buttons

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstproject.Destination
import com.example.firstproject.Room.database.CartViewModel
import com.example.firstproject.Room.database.DataCart

@Composable
fun AddingButton(
    textSize: Int,
    current: Context,
    cartViewModel: CartViewModel,
    textFieldValue: TextFieldValue,
    isDoneCheck: Boolean,
    navController: NavController
) {
    OutlinedButton(
        onClick = {
            if (textSize > 1) {
                cartViewModel.insertCart(
                    DataCart(
                        name = textFieldValue.text,
                        isDone = isDoneCheck
                    )
                )
                navController.navigate(Destination.Home.route)
            } else {
                Toast.makeText(current, "You have to enter data", Toast.LENGTH_SHORT).show()
            }

        },
        border = BorderStroke(2.dp, Color.Black),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
        modifier = Modifier.padding(top = 15.dp)

    ) {
        Text(fontSize = 18.sp, text = "Add data")
    }
}