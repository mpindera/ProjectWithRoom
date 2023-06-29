package com.example.firstproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.firstproject.ui.theme.FirstProjectTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavigationAppHost(navController)

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationAppHost(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = Color(0xFF917E7E)) {
                val navBackStackEntry = navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry.value?.destination

                BottomNavigationItem(
                    selected = currentDestination?.route == Destination.Home.route,
                    onClick = { navController.navigate(Destination.Home.route) },
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text(text = Destination.Home.route) }
                )

                BottomNavigationItem(
                    selected = currentDestination?.route == Destination.AddData.route,
                    onClick = { navController.navigate(Destination.AddData.route) },
                    icon = { Icon(Icons.Default.AddCircle, contentDescription = null) },
                    label = { Text(text = Destination.AddData.route) }
                )
            }
        }

    ) {
        NavHost(navController = navController, startDestination = Destination.Home.route) {
            composable(Destination.Home.route) { HomeScreen(navController) }
            composable(Destination.AddData.route) { AddDataCart(navController) }
        }
    }
}









