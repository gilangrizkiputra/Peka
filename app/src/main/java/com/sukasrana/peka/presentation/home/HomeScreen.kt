package com.sukasrana.peka.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sukasrana.peka.R
import com.sukasrana.peka.data.ListData
import com.sukasrana.peka.model.Balita
import com.sukasrana.peka.model.Mpasi
import com.sukasrana.peka.navigation.Screen
import com.sukasrana.peka.presentation.home.component.AddBalitaItem
import com.sukasrana.peka.presentation.component.ArtikelRekomendasiItem
import com.sukasrana.peka.presentation.home.component.BalitaItem
import com.sukasrana.peka.presentation.home.component.MpasiItem
import com.sukasrana.peka.ui.theme.blueBackground
import com.sukasrana.peka.ui.theme.bodyFontFamily
import com.sukasrana.peka.ui.theme.secondaryColor
import com.sukasrana.peka.ui.theme.secondaryTwoColor
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
    modifier: Modifier = Modifier,
    balita: List<Balita> = ListData.dataBalita,
    mpasi: List<Mpasi> = ListData.mpasi,
    artikelRekomendasi: List<Mpasi> = ListData.mpasi,

) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        item {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.background_home),
                    contentDescription = "background beranda",
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 50.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                    ) {
                        Text(
                            text = "Hai, Bunda",
                            fontFamily = bodyFontFamily,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = Color.White,
                            modifier = Modifier
                        )
                        Text(
                            text = "Sri Wahyuni",
                            fontFamily = bodyFontFamily,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            color = Color.White,
                            modifier = Modifier
                        )
                    }
                    Box(
                        modifier = Modifier
                    ) {
                        Surface(
                            modifier = modifier
                                .clip(CircleShape)
                                .size(34.dp)
                                .clickable {
                                    navController.navigate(Screen.Notification.route)
                                },
                            color = Color.White,
                        ) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                tint = Color.LightGray,
                                contentDescription = "notifikasi",
                                modifier = Modifier
                                    .size(16.dp)
                                    .padding(4.dp)
                            )
                        }
                    }
                }
            }
        }
        item {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Pantau tumbuh kembang anak",
                    fontFamily = bodyFontFamily,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.Gray,
                    modifier = Modifier
                )
                LazyRow(
                    contentPadding = PaddingValues(2.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = modifier.padding(top = 8.dp)
                ) {
                    items(balita, key = { it.id }) {
                        BalitaItem(balita = it, modifier = Modifier)
                    }
                    item {
                        AddBalitaItem(modifier = Modifier)
                    }
                }
                Row {
                    Surface(
                        modifier = modifier
                            .width(173.dp)
                            .padding(top = 16.dp),
                        color = secondaryTwoColor,
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.image_pendaftaran_online),
                                contentDescription = "pendaftaran",
                                contentScale = ContentScale.None,
                                modifier = Modifier
                                    .height(50.dp)
                                    .padding(bottom = 1.dp)
                            )
                            Text(
                                text = "Pendaftaran online",
                                fontFamily = bodyFontFamily,
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                color = Color.White,
                                lineHeight = 15.4.sp,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Surface(
                        modifier = modifier
                            .width(173.dp)
                            .padding(top = 16.dp),
                        color = secondaryTwoColor,
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.image_cek_no_antrian),
                                contentDescription = "cek antrian",
                                contentScale = ContentScale.None,
                                modifier = Modifier
                                    .height(50.dp)
                                    .padding(bottom = 1.dp)
                            )
                            Text(
                                text = "Cek No Antrian",
                                fontFamily = bodyFontFamily,
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                color = Color.White,
                                lineHeight = 15.4.sp,
                            )
                        }
                    }
                }
            }
        }
        item {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .height(450.dp)
                    .padding(top = 16.dp),
                color = blueBackground,
            ) {
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp, end = 16.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Menu Makanan Bergizi",
                            fontFamily = bodyFontFamily,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            color = Color.Black,
                        )
                        Text(
                            text = "Lihat semua",
                            fontFamily = bodyFontFamily,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = secondaryColor,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 5.dp)
                        )
                    }
                    LazyRow(
                        contentPadding = PaddingValues(2.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = modifier.padding(top = 8.dp)
                    ) {
                        items(mpasi, key = { it.id }) {
                            MpasiItem(mpasi = it, modifier = Modifier)
                        }
                    }
                    Text(
                        text = "Artikel Rekomendasi",
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color.Black,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    LazyRow(
                        contentPadding = PaddingValues(2.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = modifier.padding(top = 8.dp)
                    ) {
                        items(artikelRekomendasi, key = { it.id }) {
                            ArtikelRekomendasiItem(mpasi = it, modifier = Modifier)
                        }
                    }
                }
            }
        }
    }
}