package com.sukasrana.peka.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.sukasrana.peka.R
import com.sukasrana.peka.model.Mpasi
import com.sukasrana.peka.ui.theme.PekaTheme
import com.sukasrana.peka.ui.theme.bodyFontFamily

@Composable
fun MpasiItem(
    modifier: Modifier = Modifier,
    mpasi: Mpasi,
    onItemClicked: (Int) -> Unit
) {
    Surface(
        modifier = modifier
            .clickable { onItemClicked(mpasi.id_mpasi) }
            .width(187.dp)
            .height(140.dp),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Image(
                painter = rememberImagePainter(mpasi.image),
                contentDescription = mpasi.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(187.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(topStart = 10.dp))
            )
            Text(
                text = mpasi.title,
                fontFamily = bodyFontFamily,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp, fontWeight = FontWeight.SemiBold),
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .width(187.dp)
                    .padding(top = 8.dp, start = 8.dp),
                maxLines = 1
            )
            Text(
                text = mpasi.date,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 7.sp, fontWeight = FontWeight.ExtraLight),
                textAlign = TextAlign.Right,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp, top = 4.dp)
            )
        }
    }
}

//@Preview
//@Composable
//private fun MpasiItemHorizontalPreview() {
//    PekaTheme {
//        MpasiItem(mpasi = Mpasi(
//            1,
//            "Bubur Brokoli dan Wortel",
//            "lorem",
//            "15 Mei 24",
//            R.drawable.image_bubur_brokoli_mpasi_beranda
//        ),
//            onItemClicked = { balitaId ->
//                println("Balita Id : $balitaId")
//            }
//        )
//    }
//}