//package com.sukasrana.peka.presentation.component
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.graphicsLayer
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.sukasrana.peka.R
//import com.sukasrana.peka.model.Article
//import com.sukasrana.peka.ui.theme.PekaTheme
//import com.sukasrana.peka.ui.theme.bodyFontFamily
//
//@Composable
//fun RekomArtItem(
//    rekomArt: Article,
//    modifier: Modifier = Modifier,
//    onItemClicked: (Int) -> Unit,
//) {
//    Box(
//        modifier = modifier
//
//            .padding(start = 4.dp, top = 8.dp, end = 16.dp, bottom = 16.dp)  // Menambahkan padding di kiri, atas, dan kanan
//            .size(width = 245.dp, height = 190.dp)
//            .graphicsLayer(
//
//                shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp) // Menambahkan radius di sudut kiri atas dan kanan atas
//            )
//            .shadow(4.dp) // Elevation untuk bayangan
//    ) {
//        // Box untuk konten sebenarnya
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier
//                .clickable { onItemClicked(rekomArt.id_artikel }
//                .fillMaxSize()
//                .clip(RoundedCornerShape(5.dp)) // Menambahkan radius pada sisi kanan bawah dan kiri bawah
//                .background(Color.White) // Latar belakang putih agar bayangan terlihat jelas
//        ) {
//            Image(
//                painter = painterResource(id = rekomArt.photo),
//                contentDescription = stringResource(id = rekomArt.title),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clip(RoundedCornerShape(5.dp))
//            )
//            Text(
//                text = stringResource(id = rekomArt.title),
//                fontFamily = bodyFontFamily,
//                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 11.sp, fontWeight = FontWeight.SemiBold),
//                textAlign = TextAlign.Left,
//                modifier = Modifier.fillMaxWidth().padding(start = 8.dp, top = 4.dp, end = 8.dp)
//
//            )
//            Text(
//                text = rekomArt.date,
//                fontFamily = bodyFontFamily,
//                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 7.sp, fontWeight = FontWeight.ExtraLight),
//                textAlign = TextAlign.Right,
//                modifier = Modifier.fillMaxWidth().padding(end = 8.dp, top = 4.dp)
//
//            )
//        }
//    }
//
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun BossHorizontalPreview() {
//    PekaTheme {
//        RekomArtItem(
//            rekomArt = Article(1, R.string.titleArticle1, R.string.contentArticle1, "2 Januari 2024", R.drawable.nutrisi),
//            onItemClicked = { articleId ->
//                println("Boss Id : $articleId")
//            }
//        )
//    }
//}
