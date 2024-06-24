package com.sukasrana.peka.presentation.profile

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.ContentAlpha
import com.sukasrana.peka.ui.theme.PekaTheme

data class Card (
        val title: String,
        val Desc: String
        )

@Composable
fun FeedbackScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val cardData1 = listOf(
        Card("Apakah saya bisa mendaftarkan lebih dari satu anak?", "Ya, Anda dapat mendaftarkan lebih dari satu anak di aplikasi ini."),
        Card("Apakah pendaftaran online ini gratis?", "Ya, aplikasi ini gratis dan aplikasi ini terhubung dengan posyandu Madiun daerah Manggis.")
    )
    val cardData2 = listOf(
        Card("Bagaimana cara melihat grafik perkembangan anak saya?", "Anda dapat melihat grafik perkembangan dengan cara memilih balita yang telah anda tambahkan. Data akan bertambah setiap anda melakukan kunjungan ke posyandu."),
        Card("Apa saja parameter yang dilacak dalam fitur pantau tumbuh kembang anak?", "Untuk parameter yang dilacak adalah berat badan dan tinggi badan."),
    )
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        item{
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
                    text = "Bantuan",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        item {
            Text(
                text = "Pendaftaran Online",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp))
        }
        items(cardData1) {cardData ->
            CardContent(title = cardData.title, desc = cardData.Desc)
        }
        item {
            Text(
                text = "Pantau Tumbuh Kembang Anak",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp))
        }
        items(cardData2) {cardData1 ->
            CardContent(title = cardData1.title, desc = cardData1.Desc)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CardContent(
    title: String,
    desc: String
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    val rotateState by animateFloatAsState(
        targetValue = if(expanded) 90f else -90f)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = RoundedCornerShape(0.dp),
        onClick = {
            expanded = !expanded
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.background)
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = title,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotateState),
                    onClick = {
                        expanded = !expanded
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "ArrDrop"
                    )
                }
            }
            if(expanded){
                Text(
                    text = desc,
                    style = MaterialTheme.typography.bodySmall)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun FeedbackScreenPreview() {
    PekaTheme {
        FeedbackScreen(rememberNavController())
    }
}