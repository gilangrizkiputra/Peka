package com.sukasrana.peka.presentation.screen.onboarding

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.sukasrana.peka.ui.theme.bodyFontFamily

@Composable
fun OnBoardingScreen(
    navController: NavController,
    modifier: Modifier = Modifier
){
    Text(text = "Ini OnBoarding", fontFamily = bodyFontFamily)
}

@Composable
fun OnBoardingContent(){

}