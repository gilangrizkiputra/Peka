package com.sukasrana.peka.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.sukasrana.peka.R
import com.sukasrana.peka.model.Article
import com.sukasrana.peka.model.Mpasi
import com.sukasrana.peka.model.MpasiModel
import com.sukasrana.peka.ui.theme.PekaTheme
import com.sukasrana.peka.ui.theme.bodyFontFamily

@Composable
fun MpasiItem(
    mpasi: Mpasi,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clickable {
                onItemClicked(mpasi.id_mpasi)
            }
            .fillMaxWidth()
            .padding(start = 16.dp)
            .width(360.dp)
            .height(117.dp)
    ) {
        Image(
            painter = rememberImagePainter(mpasi.image),
            contentDescription = mpasi.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(130.dp, 85.dp)
                .clip(RoundedCornerShape(5.dp))
        )

        Column (
            modifier = Modifier
                .padding(start = 8.dp)
        ){
            Text(
                text = mpasi.title,
                fontFamily = bodyFontFamily,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = modifier

            ){
                Box (
                    modifier = Modifier.padding(top = 4.dp)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.ic_mpasi),
                        contentDescription =mpasi.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(10.dp, 10.dp)

                    )

                }
                Text(
                    text = "Resep Mpasi ${mpasi.category} Makan Pagi, Makan Siang, Makan Malam",
                    fontFamily = bodyFontFamily,
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 8.sp, fontWeight = FontWeight.Normal, lineHeight = 10.sp),
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(180.dp, 30.dp)
                )
            }
            Text(
                text = mpasi.date,
                fontFamily = bodyFontFamily,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 8.sp, fontWeight = FontWeight.Normal),
                modifier = Modifier.padding(top = 16.dp)
            )
        }

    }

}


//@Preview(showBackground = true)
//@Composable
//private fun MpasiItemPreview() {
//    PekaTheme {
//        MpasiItem(
//            mpasi = MpasiModel(1,"Resep MPASI, 6 Bulan, Makan Pagi ,Makan Siang, Makan Malam", R.string.menu_buburWortel, R.string.gizi_buburWortel, R.string.bahan_buburWortel,R.string.cara_buburWortel,
//                6,"12 Januari 2024", R.drawable.nutrisi,R.drawable.ic_mpasi),
//            onItemClicked = { articleId ->
//                println("Article Id : $articleId")
//            }
//        )
//    }
//}