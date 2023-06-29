package com.example.firstproject.textfields

import android.provider.ContactsContract.Data
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.firstproject.Destination
import com.example.firstproject.Room.database.CartViewModel
import com.example.firstproject.Room.database.DataCart

data class TextFieldConfig(
    val label: String,
    val focusedBorderColor: Color,
    val unfocusedBorderColor: Color,
    val textColor: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldAddingData(
    textFields: List<TextFieldConfig>,
    cartViewModel: CartViewModel,
    navController: NavController
) {
    var textFieldValue by remember {
        mutableStateOf(TextFieldValue())
    }

    var isDoneCheck by remember {
        mutableStateOf(false)
    }

    Column {
        textFields.forEach { config ->
            val maxLength = 30
            OutlinedTextField(
                value = textFieldValue.text,
                onValueChange = { newValue ->
                    if (newValue.length <= maxLength) {
                        textFieldValue = textFieldValue.copy(text = newValue)
                    }
                },
                singleLine = true,
                label = { Text(text = config.label) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = config.focusedBorderColor,
                    unfocusedBorderColor = config.unfocusedBorderColor,
                    textColor = config.textColor
                ),
                modifier = Modifier.width(250.dp)

            )
            Text(
                text = "${textFieldValue.text.length} / $maxLength",
                modifier = Modifier
                    .padding(top = 4.dp),
                textAlign = TextAlign.End,
                color = Black
            )
        }
    }
    OutlinedButton(
        onClick = {
            cartViewModel.insertCart(DataCart(name = textFieldValue.text, isDone = isDoneCheck))
            navController.navigate(Destination.Home.route)
        },
        border = BorderStroke(2.dp, Black),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Black),
        modifier = Modifier.padding(top = 15.dp)
    ) {
        Text(fontSize = 18.sp, text = "Add data")
    }
}














