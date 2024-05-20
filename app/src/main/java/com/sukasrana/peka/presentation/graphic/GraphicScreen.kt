package com.sukasrana.peka.presentation.graphic

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Male
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.R
import com.sukasrana.peka.data.ListData
import com.sukasrana.peka.model.Mpasi
import com.sukasrana.peka.presentation.component.ArtikelRekomendasiItem
import com.sukasrana.peka.ui.theme.PekaTheme
import com.sukasrana.peka.ui.theme.onPrimaryLight
import com.sukasrana.peka.ui.theme.secondaryColor
import com.sukasrana.peka.ui.theme.secondaryTwoColor

@Composable
fun GraphicScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    artikelRekomendasi: List<Mpasi> = ListData.mpasi
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        item {
            Column {
                IconButton(
                    onClick = { navController.navigateUp() },
                    modifier = modifier
                        .padding(start = 10.dp, top = 10.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = modifier
                            .size(50.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Pantau Tumbuh Kembang Anak",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.SemiBold),
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(5.dp)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.image_balita_beranda),
                        contentDescription = "Balita",)
                    Text(
                        text = "Asep knalpot",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                            .padding(10.dp))
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .width(80.dp)
                            .height(100.dp)
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(secondaryTwoColor)
                    ) {
                        Box(
                            contentAlignment = Alignment.CenterStart,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(37.dp)
                                .clip(shape = RoundedCornerShape(5.dp))
                                .background(secondaryColor)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.ic_berat_badan),
                                contentDescription = "icon berat badan",
                                modifier = Modifier.padding(9.dp))
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(3.dp)) {
                            Text(text = "Berat Badan", style = MaterialTheme.typography.bodySmall, textAlign = TextAlign.Center)
                            Text(text = "15 Kg", style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                    Column(
                        modifier = Modifier
                            .width(80.dp)
                            .height(100.dp)
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(secondaryTwoColor)
                    ) {
                        Box(
                            contentAlignment = Alignment.CenterStart,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(37.dp)
                                .clip(shape = RoundedCornerShape(5.dp))
                                .background(secondaryColor)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.ic_tinggi_badan),
                                contentDescription = "icon tinggi badan",
                                modifier = Modifier.padding(9.dp))
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(3.dp)) {
                            Text(text = "Tinggi Badan", style = MaterialTheme.typography.bodySmall, textAlign = TextAlign.Center)
                            Text(text = "75 cm", style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                    Column(
                        modifier = Modifier
                            .width(80.dp)
                            .height(100.dp)
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(secondaryTwoColor)
                    ) {
                        Box(
                            contentAlignment = Alignment.CenterStart,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(37.dp)
                                .clip(shape = RoundedCornerShape(5.dp))
                                .background(secondaryColor)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.ic_umur),
                                contentDescription = "icon umur",
                                modifier = Modifier.padding(9.dp))
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(3.dp)) {
                            Text(text = "Umur", style = MaterialTheme.typography.bodySmall, textAlign = TextAlign.Center)
                            Text(text = "10 Bulan", style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                    Column(
                        modifier = Modifier
                            .width(80.dp)
                            .height(100.dp)
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(secondaryTwoColor)
                    ) {
                        Box(
                            contentAlignment = Alignment.CenterStart,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(37.dp)
                                .clip(shape = RoundedCornerShape(5.dp))
                                .background(secondaryColor)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.ic_jenis_kelamin),
                                contentDescription = "icon timbangan",
                                modifier = Modifier.padding(9.dp))
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(3.dp)) {
                            Text(text = "Jenis kelamin", style = MaterialTheme.typography.bodySmall, textAlign = TextAlign.Center)
                            Icon(imageVector = Icons.Default.Male, contentDescription = "Gender icon")
                        }
                    }
                }
            }
        }
        item {
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.primary)
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Kondisi Berat Badan",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.padding(bottom = 5.dp))
                        Image(
                            painter = painterResource(id = R.drawable.grafik_berat_badan),
                            contentDescription = "grafik berat badan",
                            modifier = Modifier.fillMaxWidth())
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.primary)
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Tinggi Badan",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.padding(bottom = 5.dp))
                        Image(
                            painter = painterResource(id = R.drawable.grafik_tinggi_badan),
                            contentDescription = "grafik tinggi badan",
                            modifier = Modifier
                                .fillMaxWidth())
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(onPrimaryLight)
                            .padding(10.dp)
                    ) {
                        Row{
                            Text(
                                text = "Interpetrasi :",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(2.dp))
                            Text(
                                text = "Kekurangan Berat Badan",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(5.dp))
                                    .background(Color.Red)
                                    .padding(start = 5.dp, top = 2.dp, bottom = 2.dp, end = 5.dp)
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(50.dp)
                                    .clip(shape = RoundedCornerShape(10.dp))
                                    .background(secondaryTwoColor)
                            ) {
                                Text(text = "Berat : 15 kg", style = MaterialTheme.typography.bodyLarge)
                            }
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(50.dp)
                                    .clip(shape = RoundedCornerShape(10.dp))
                                    .background(secondaryTwoColor)
                            ) {
                                Text(text = "Tinggi : 75 cm", style = MaterialTheme.typography.bodyLarge)
                            }
                        }
                        Text(
                            text = "Anak Anda Mengalami Kekurangan berat badan, Jadwalkan kunjuangan ke dokter atau fasilitas kesehatan terdekat untuk informasi lebih lanjut ",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Justify)
                    }
                }
            }
        }
        item {
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.onPrimary
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Rekomendasi Makanan Untuk Asupan Gizi", style = MaterialTheme.typography.labelLarge)
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

@Preview(showBackground = true)
@Composable
private fun GraphicScreenPreview() {
    PekaTheme {
        GraphicScreen(navController = rememberNavController())
    }
}