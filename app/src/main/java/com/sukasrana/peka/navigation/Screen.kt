package com.sukasrana.peka.navigation

sealed class Screen(val route: String){
    data object Splash: Screen("splash")
    data object OnBoarding: Screen("onboarding")
    data object Switch: Screen("switch")
    data object Login: Screen("login")
    data object Signup: Screen("signup")
    data object Home : Screen("home")

    data object Balita : Screen("balita")
    data object Article : Screen("Article")
    data object DetailArticle : Screen("detail_article")
    data object Mpasi : Screen("Mpasi")
    data object DetailMpasi : Screen("detail_mpasi")
    data object Mkia : Screen("detail_mkia")
    data object MkiaDetail : Screen("detail_mkia")
    data object Profile : Screen("profile")
    data object About : Screen("about")
    data object ProEdit : Screen("proedit")
    data object Feedback : Screen("feedback")
    data object Notification : Screen("notification")
    data object TambahIdentitasAnak : Screen("tambah identitas anak")
    data object PendaftaranOnlineAnak : Screen("Pendaftaran Online")
    data object CekNoAntrian : Screen("Cek Nomor Antrian")
}
