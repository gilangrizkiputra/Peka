package com.sukasrana.peka.presentation.splash

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.R
import com.sukasrana.peka.navigation.Screen
import com.sukasrana.peka.ui.theme.PekaTheme
import com.sukasrana.peka.ui.theme.primaryDark
import com.sukasrana.peka.ui.theme.primaryLight
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember { androidx.compose.animation.core.Animatable(0f) }
    val isDarkMode = isSystemInDarkTheme()

    LaunchedEffect(
        key1 = true,
        block = {
            scale.animateTo(
                targetValue = 0.9f,
                animationSpec = tween(
                    durationMillis = 800
                )
            )
            delay(1500L)
            navController.navigate(Screen.OnBoarding.route) {
                popUpTo(Screen.Splash.route) {
                    inclusive = true
                }
            }
        }
    )

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val color = if (isDarkMode){primaryDark}else{primaryLight}
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(primaryLight)
        ) {
            val image = if (isDarkMode) {
                R.drawable.logo_login_regis
            } else {
                R.drawable.logo_peka
            }
            Image(painter = painterResource(id = image), contentDescription = null)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview(){
    PekaTheme {
        SplashScreen(navController = rememberNavController())
    }
}