package com.sukasrana.peka.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.ui.theme.PekaTheme
import com.sukasrana.peka.ui.theme.bodyFontFamily

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
){
    Column {
        Text(text = "Halo! Ini Home", fontFamily = bodyFontFamily)
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview(){
    PekaTheme {
        HomeScreen(navController = rememberNavController())
    }
}