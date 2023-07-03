package com.example.firstproject.textfields

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firstproject.Room.database.CartViewModel
import com.example.firstproject.buttons.AddingButton
import com.example.firstproject.ui.theme.darkerGrey
import com.example.firstproject.ui.theme.white

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

    val isDoneCheck by remember {
        mutableStateOf(false)
    }

    val maxLength = 30

    val darkTheme: Boolean = isSystemInDarkTheme()
    val color: Color = if (darkTheme) darkerGrey else white

    val textSize = textFieldValue.text.length
    val current = LocalContext.current

    Column(
        modifier = Modifier
            .background(color)
            .padding(bottom = 15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        textFields.forEach { config ->

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
                modifier = Modifier
                    .width(250.dp)
                    .padding(15.dp)
            )
            Text(
                text = "${textFieldValue.text.length} / $maxLength",
                modifier = Modifier
                    .padding(top = 4.dp),
                textAlign = TextAlign.End,
                color = Black
            )
        }

        AddingButton(textSize, current, cartViewModel, textFieldValue, isDoneCheck, navController)
    }

}














