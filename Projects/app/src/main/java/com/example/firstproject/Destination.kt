package com.example.firstproject

sealed class Destination(val route: String) {
    object AddData : Destination("Add")
    object Home : Destination("Home")
}