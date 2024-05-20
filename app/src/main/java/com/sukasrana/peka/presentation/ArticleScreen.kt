package com.sukasrana.peka.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.data.ListData
import com.sukasrana.peka.model.Article
import com.sukasrana.peka.presentation.component.RekomArtItem
import com.sukasrana.peka.presentation.component.ArticleItem
import com.sukasrana.peka.ui.theme.bodyFontFamily


@Composable
fun ArticleScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    recomArt: List<Article> = ListData.TheArticel,
    article: List<Article> = ListData.TheArticel,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.background(Color.White)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 8.dp)
                    .background(Color.White)
            ) {
                Text(
                    text = "Artikel Kesehatan",
                    fontFamily = bodyFontFamily,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 19.sp,
                        fontWeight = FontWeight.SemiBold),
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            LazyRow(
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier.background(Color.White)
            ) {
                items(recomArt, key = { it.id }) {
                    RekomArtItem(rekomArt = it) { recomartId ->
                        // navigate to detail screen
                    }
                }
            }
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp, start = 16.dp)
                    .background(color = Color(0xE4F3FD))
            ) {
                Text(
                    text = "Baca Artikel lainnya",
                    fontFamily = bodyFontFamily,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 14.sp, fontWeight = FontWeight.SemiBold),
                    textAlign = TextAlign.Left
                )
            }
        }
        items(article, key = { it.id }) {
            ArticleItem(article = it) { articleId ->
                // navigate to detail map screen
            }
        }


    }
}

@Preview
@Composable
private fun PreviewHomeScreen() {
    val navController = rememberNavController()
    ArticleScreen(navController)
}
