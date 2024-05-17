package com.sukasrana.peka.navigation
 sealed class Screen(val route: String) {
  data object Splash: Screen("splash")
  data object OnBoarding: Screen("onboarding")
  data object Switch: Screen("switch")
  data object Login: Screen("login")
  data object Signin: Screen("signin")
  data object Home: Screen("home")
 }