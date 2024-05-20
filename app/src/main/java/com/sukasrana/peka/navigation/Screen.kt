package com.sukasrana.peka.navigation

sealed class Screen(val route: String){
    data object Splash: Screen("splash")
    data object OnBoarding: Screen("onboarding")
    data object Switch: Screen("switch")
    data object Login: Screen("login")
    data object Signup: Screen("signup")
    data object Home : Screen("home")
    data object Article : Screen("Article")
    data object Mkia : Screen("MKIA")
    data object Profile : Screen("profile")
    data object Notification : Screen("notification")
    data object TambahIdentitasAnak : Screen("tambah identitas anak")
    data object PendaftaranOnlineAnak : Screen("Pendaftaran Online")
}
