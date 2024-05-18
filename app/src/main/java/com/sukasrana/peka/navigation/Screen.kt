package com.sukasrana.peka.navigation

sealed class Screen(val route: String){
    data object Home : Screen("home")
    data object Article : Screen("Article")
    data object Mkia : Screen("MKIA")
    data object Profile : Screen("profile")
    data object Notification : Screen("notification")
}