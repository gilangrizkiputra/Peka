package com.sukasrana.peka.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.R
import com.sukasrana.peka.ui.theme.PekaTheme

@Composable
fun AboutScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .shadow(elevation = 1.dp)
        ) {
            IconButton(
                onClick = { navController.navigateUp() },
                modifier = modifier
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = modifier
                        .size(30.dp)
                )
            }
            Text(
                text = "Tentang Aplikasi",
                style = MaterialTheme.typography.titleMedium
            )
        }
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Tentang Kami",
                style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = modifier.padding(10.dp))
            Text(
                text = stringResource(id = R.string.About),
                style = MaterialTheme.typography.bodyLarge)
        }
        Box(
            modifier = modifier
                .fillMaxSize()
        ){
            Image(
                painter = painterResource(id = R.drawable.logo_peka_no_text),
                contentDescription = "Logo Peka",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAboutScreen(){
    PekaTheme {
        AboutScreen(navController = rememberNavController())
    }
}