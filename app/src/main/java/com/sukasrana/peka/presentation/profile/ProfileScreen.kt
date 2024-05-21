package com.sukasrana.peka.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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

@Composable
fun ProfileScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.padding(top = 32.dp, start = 16.dp, end = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_profile),
                contentDescription = "profile"
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(78.dp)
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = "Sri Wahyuni",
                    fontFamily = bodyFontFamily,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold),
                    )
                Text(
                    text = "+62 87907654321",
                    fontFamily = bodyFontFamily,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal),
                    modifier = Modifier
                )
            }
        }
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Surface(
                modifier = modifier
                    .fillMaxWidth()
                    .height(64.dp),
                    //.clickable { onItemClicked(balita.id) }
                    //.clickable { navController.navigate(Screen.Balita.route) }
                color = MaterialTheme.colorScheme.surface,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_ganti_profil),
                        contentDescription = "ic profile",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Profil",
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "Arrow",
                    modifier = Modifier
                )
            }
        }
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .height(64.dp),
            //.clickable { onItemClicked(balita.id) }
            //.clickable { navController.navigate(Screen.Balita.route) }
            color = MaterialTheme.colorScheme.surface,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_tentang_kami),
                        contentDescription = "ic tentang kami",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Tentang Kami",
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "Arrow",
                    modifier = Modifier
                )
            }
        }
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .height(64.dp),
            //.clickable { onItemClicked(balita.id) }
            //.clickable { navController.navigate(Screen.Balita.route) }
            color = MaterialTheme.colorScheme.surface,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_bantuan),
                        contentDescription = "ic bantuan",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Bantuan",
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "Arrow",
                    modifier = Modifier
                )
            }
        }
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .height(64.dp),
            //.clickable { onItemClicked(balita.id) }
            //.clickable { navController.navigate(Screen.Balita.route) }
            color = MaterialTheme.colorScheme.surface,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_logout),
                        contentDescription = "ic logout",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Log Out",
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ProfilePrev() {
    ProfileScreen(navController = rememberNavController())
}