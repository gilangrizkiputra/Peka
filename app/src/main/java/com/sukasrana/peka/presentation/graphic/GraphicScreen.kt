package com.sukasrana.peka.presentation.graphic

import android.util.Log
import android.annotation.SuppressLint
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
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import co.yml.charts.common.model.Point
import com.sukasrana.peka.R
import com.sukasrana.peka.data.ListData
import com.sukasrana.peka.data.repository.fetchArticles
import com.sukasrana.peka.data.ListData.DataBerat
import com.sukasrana.peka.data.repository.fetchBaliatById
import com.sukasrana.peka.data.repository.fetchDataBaliatById
import com.sukasrana.peka.model.Article
import com.sukasrana.peka.model.Balita
import com.sukasrana.peka.model.DataBalita
import com.sukasrana.peka.presentation.component.ArtikelRekomendasiItem
import com.sukasrana.peka.presentation.graphic.component.BeratChat
import com.sukasrana.peka.presentation.graphic.component.StatusBalita
import com.sukasrana.peka.presentation.graphic.component.TinggiBadan
import com.sukasrana.peka.presentation.home.component.AgeCalculator
import com.sukasrana.peka.ui.theme.PekaTheme
import com.sukasrana.peka.ui.theme.onPrimaryLight
import com.sukasrana.peka.ui.theme.secondaryColor
import com.sukasrana.peka.ui.theme.secondaryTwoColor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@SuppressLint("UnrememberedMutableState")
@Composable
fun GraphicScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    balitaId: Int?
) {
    var balita by remember { mutableStateOf<Balita?>(null) }
    val dataBalita = remember { mutableStateListOf<DataBalita?>() }
    val artikelRekomendasi = remember { mutableStateOf<List<Article>>(emptyList()) }
    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            val data = balitaId?.let { fetchBaliatById(it) }
            val dataB = balitaId?.let { fetchDataBaliatById(it) }
            if (data != null) {
                balita = data[0]
            }
            if (dataB != null) {
                dataBalita.clear()
                dataBalita.addAll(dataB)
            }

            Log.d("GraphicScreen", "Fetching articles")
            val articles = fetchArticles()
            if (articles != null) {
                Log.d("GraphicScreen", "Articles fetched: $articles")
                artikelRekomendasi.value = articles
            } else {
                Log.e("GraphicScreen", "Failed to fetch articles")
            }
        }
    }
    val lastData = dataBalita.lastOrNull()

    var status: String = "out"
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        item {
            Column {
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
                Text(
                    text = "Pantau Tumbuh Kembang Anak",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 16.dp)
                )
                balita?.let { balita ->
                    val dob = balita.birth_date
                    val (years, months) = AgeCalculator(dob)
                    val status = lastData?.let {
                        StatusBalita(years = years, months = months, weight = it.weight)
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(20.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.image_balita_beranda),
                            contentDescription = "Balita",
                        )

                        Text(
                            text = balita.nama,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier
                                .padding(10.dp)
                        )
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
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_berat_badan),
                                    contentDescription = "icon berat badan",
                                    modifier = Modifier.padding(9.dp)
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(3.dp)
                            ) {
                                Text(
                                    text = "Berat Badan",
                                    style = MaterialTheme.typography.bodySmall,
                                    textAlign = TextAlign.Center
                                )
                                if (lastData != null) {
                                    Text(
                                        text = "${lastData.weight}",
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                } else {
                                    Text(
                                        text = "Belum Ada Data",
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                }
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
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_tinggi_badan),
                                    contentDescription = "icon tinggi badan",
                                    modifier = Modifier.padding(9.dp)
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(3.dp)
                            ) {
                                Text(
                                    text = "Tinggi Badan",
                                    style = MaterialTheme.typography.bodySmall,
                                    textAlign = TextAlign.Center
                                )
                                if (lastData != null) {
                                    Text(
                                        text = "${lastData.height}",
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                } else {

                                    Text(
                                        text = "Belum Ada Data",
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                }
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
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_umur),
                                    contentDescription = "icon umur",
                                    modifier = Modifier.padding(9.dp)
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(3.dp)
                            ) {
                                Text(
                                    text = "Umur",
                                    style = MaterialTheme.typography.bodySmall,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = if (years < 1) {
                                        "$months bulan"
                                    } else {
                                        "$years tahun $months bulan"
                                    },
                                    style = MaterialTheme.typography.bodyLarge
                                )
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
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_jenis_kelamin),
                                    contentDescription = "icon timbangan",
                                    modifier = Modifier.padding(9.dp)
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(3.dp)
                            ) {
                                Text(
                                    text = if (balita.gender == "man") "Laki - Laki" else "Perempuan",
                                    style = MaterialTheme.typography.bodySmall,
                                    textAlign = TextAlign.Center
                                )
                                Icon(
                                    imageVector = if (balita.gender == "man") Icons.Default.Male else Icons.Default.Female,
                                    contentDescription = "Gender icon"
                                )
                            }
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
                            text = "Kondisi Berat Badan (Kg)",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                        if (balitaId != null) {
                            BeratChat(balitaId = balitaId)
                        }
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
                            text = "Tinggi Badan (cm)",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                        balitaId?.let { TinggiBadan(balitaId = it) }
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
                        balita?.let { balita ->
                            val dob = balita.birth_date
                            val (years, months) = AgeCalculator(dob)
                            val status = lastData?.let {
                                StatusBalita(years = years, months = months, weight = it.weight)
                            }
                            Row {
                                Text(
                                    text = "Interpetrasi :",
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.padding(2.dp)
                                )
                                val color = if(status == "kurang" || status == "lebih") Color.Red else Color.Green
                                Text(
                                    text = when{
                                        status == "kurang" -> "Kurang berat badan"
                                        status == "sedang" -> "Berat badan ideal"
                                        status == "lebih" -> "lebih berat badan"
                                        else -> "Umur lebih dari 2 tahun"
                                    },
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier
                                        .clip(shape = RoundedCornerShape(5.dp))
                                        .background(color)
                                        .padding(
                                            start = 5.dp,
                                            top = 2.dp,
                                            bottom = 2.dp,
                                            end = 5.dp
                                        )
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
                                    if (lastData != null) {
                                        Text(
                                            text = "Berat : ${lastData.weight} kg",
                                            style = MaterialTheme.typography.bodyLarge
                                        )
                                    } else {
                                        Text(
                                            text = "Belum ada data",
                                            style = MaterialTheme.typography.bodyLarge
                                        )
                                    }
                                }
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .width(120.dp)
                                        .height(50.dp)
                                        .clip(shape = RoundedCornerShape(10.dp))
                                        .background(secondaryTwoColor)
                                ) {
                                    if (lastData != null) {
                                        Text(
                                            text = "Tinggi : ${lastData.height} cm",
                                            style = MaterialTheme.typography.bodyLarge
                                        )
                                    } else {
                                        Text(
                                            text = "Belum ada data",
                                            style = MaterialTheme.typography.bodyLarge
                                        )
                                    }
                                }
                            }
                            Text(
                                text = when{
                                    status == "kurang" -> "Anak anda mengalami Kekurangan berat badan, Jadwalkan kunjuangan ke dokter atau fasilitas kesehatan terdekat untuk informasi lebih lanjut."
                                    status == "sedang" -> "Anak anda memiliki berat badan yang ideal"
                                    status == "lebih" -> "Anak anda mengalami kelebihan berat badan, Jadwalkan kunjuangan ke dokter atau fasilitas kesehatan terdekat untuk informasi lebih lanjut."
                                        else -> "Umur balita anda lebih dari 2 tahun"
                                },
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Justify
                            )
                        }
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
                    Text(
                        text = "Rekomendasi Makanan Untuk Asupan Gizi",
                        style = MaterialTheme.typography.labelLarge
                    )
                    LazyRow(
                        contentPadding = PaddingValues(2.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = modifier.padding(top = 8.dp)
                    ) {
                        items(artikelRekomendasi.value, key = { it.id_artikel }) {
                            ArtikelRekomendasiItem(rekomArt = it) { articleId ->
                                navController.navigate("detail_article/$articleId")
                            }
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
        GraphicScreen(navController = rememberNavController(), balitaId = 1)
    }
}