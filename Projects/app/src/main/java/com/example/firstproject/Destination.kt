package com.example.firstproject

sealed class Destination(val route: String) {
    object AddData : Destination("add_data")
    object Home : Destination("home")
}