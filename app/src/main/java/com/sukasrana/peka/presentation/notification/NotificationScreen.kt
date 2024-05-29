package com.sukasrana.peka.presentation.notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.R
import com.sukasrana.peka.ui.theme.bodyFontFamily
import com.sukasrana.peka.ui.theme.primaryColor

@Composable
fun NotificationScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image_notifikasi),
                    contentDescription = "notifikasi background"
                )
                Text(
                    text = "Anda belum mempunyai notifikasi",
                    fontFamily = bodyFontFamily,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = primaryColor,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
    IconButton(
        onClick = { navController.navigateUp() },
        modifier = modifier
            .padding(7.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            modifier = modifier
                .size(30.dp)
        )
    }
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Notifikasi",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview
@Composable
private fun PreviewNotificationScreen() {
    NotificationScreen(
        navController = rememberNavController(),
        onItemClicked = { println("IdNot") }
    )
}