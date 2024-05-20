package com.sukasrana.peka.presentation.cekNoAntrian

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.R
import com.sukasrana.peka.navigation.Screen
import com.sukasrana.peka.presentation.addFormChild.AddFormChildScreen
import com.sukasrana.peka.ui.theme.PekaTheme
import com.sukasrana.peka.ui.theme.bodyFontFamily
import com.sukasrana.peka.ui.theme.secondaryTwoColor

@Composable
fun CekNoAntrianScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = Modifier
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_no_antrian),
                contentDescription = "image no antrian",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "No Antrian Bunda :",
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp,
                textAlign = TextAlign.Start,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Surface(
                modifier = modifier
                    .width(252.dp)
                    .height(184.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(BorderStroke(width = 2.dp, Color.Black)),
                shadowElevation = 0.dp,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                ) {
                    Text(
                        text = "12 April 2024",
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            textAlign = TextAlign.Start,
                            lineHeight = 11.2.sp,
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Normal),
                        color = Color.Black,
                    )
                    Text(
                        text = "Posyandu Manggis",
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            textAlign = TextAlign.Center,
                            lineHeight = 11.2.sp,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color.Black,
                        modifier = Modifier
                            .width(252.dp)
                            .padding(top = 16.dp)
                    )
                    Text(
                        text = "Nomor Antrian",
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            textAlign = TextAlign.Center,
                            lineHeight = 11.2.sp,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        color = Color.Black,
                        modifier = Modifier
                            .width(252.dp)
                            .padding(top = 8.dp)
                    )
                    Text(
                        text = "A001",
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            textAlign = TextAlign.Center,
                            lineHeight = 11.2.sp,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color.Black,
                        modifier = Modifier
                            .width(252.dp)
                    )
                    Text(
                        text = "Terima Kasih Sudah Melakukan\nPendaftaran di Posyandu Manggis !",
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            textAlign = TextAlign.Center,
                            lineHeight = 11.2.sp,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        color = Color.Black,
                        modifier = Modifier
                            .width(252.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(32.dp))
        ButtonBackToHome(
            onBackClick = {
                navController.navigate(Screen.Home.route)
            }
        )
    }
}

@Composable
fun ButtonBackToHome(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    ) {
    Button(
        onClick = onBackClick,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(48.dp),
    ) {
        Text(
            text = "Kembali Ke Beranda",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
@Preview(showSystemUi = true)
@Composable
private fun CekNoAntrianPrev() {
    PekaTheme {
        CekNoAntrianScreen(navController = rememberNavController())
    }
}