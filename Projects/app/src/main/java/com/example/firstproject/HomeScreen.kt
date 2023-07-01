package com.example.firstproject

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.firstproject.Room.database.CartViewModel
import com.example.firstproject.Room.database.DataCart
import com.example.firstproject.ui.theme.darkerGrey
import com.example.firstproject.ui.theme.darkGrey
import com.example.firstproject.ui.theme.white

@Composable
fun HomeScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val viewModelCart: CartViewModel = viewModel()
        val carts = viewModelCart.cart.observeAsState(listOf()).value
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp)
                .blur(90.dp)
        ) {

            Text(
                text = stringResource(R.string.my_data),
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
            )
            Spacer(modifier = Modifier.padding(bottom = 16.dp))

            CartList(carts = carts, cartView = viewModelCart)
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CartList(
    carts: List<DataCart>,
    cartView: CartViewModel
) {
    val darkTheme: Boolean = isSystemInDarkTheme()
    val color: Color = if (darkTheme) darkerGrey else white

    LazyColumn {
        items(carts) { cart ->

            val isDoneCheck = rememberSaveable {
                mutableStateOf(cart.isDone)
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp),
                backgroundColor = color
            ) {
                androidx.compose.material.ListItem(
                    modifier = Modifier
                    .blur(90.dp)
                    .background(Color.Transparent),

                    text = {
                        Text(text = cart.name)
                           },

                    icon = {
                        IconButton(onClick = {
                            cartView.deleteCart(cart)
                        }) {
                            Icon(
                                Icons.Default.Delete,
                                contentDescription = null
                            )
                        }
                    },

                    trailing = {
                        Checkbox(
                            checked = isDoneCheck.value,
                            onCheckedChange = {
                                isDoneCheck.value = it
                                cart.isDone = isDoneCheck.value
                                cartView.updateCart(cart)
                            },
                        )
                    }
                )
            }
        }
    }
}