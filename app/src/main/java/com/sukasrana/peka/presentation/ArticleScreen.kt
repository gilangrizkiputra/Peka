
package com.sukasrana.peka.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.sukasrana.peka.data.repository.fetchArticles
import com.sukasrana.peka.model.Article
import com.sukasrana.peka.presentation.component.ArticleItem
import com.sukasrana.peka.presentation.component.ArtikelRekomendasiItem
import com.sukasrana.peka.ui.theme.bodyFontFamily
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun ArticleScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val recomArt = remember { mutableStateOf<List<Article>>(emptyList()) }
    val article = remember { mutableStateOf<List<Article>>(emptyList()) }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            val articles = fetchArticles()
            if (articles != null) {
                recomArt.value = articles
                article.value = articles
            }
        }
    }

    if (article.value.isEmpty()){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "No article available",
                    fontFamily = bodyFontFamily,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.background(MaterialTheme.colorScheme.background)
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
                    items(recomArt.value, key = { it.id_artikel }) {
                        ArtikelRekomendasiItem(rekomArt = it) { articleId ->
                            navController.navigate("detail_article/$articleId")
                        }
                    }
                }

            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 8.dp, start = 16.dp)
                ) {
                    Text(
                        text = "Baca Artikel lainnya",
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 14.sp, fontWeight = FontWeight.SemiBold),
                        textAlign = TextAlign.Left
                    )
                }
            }
            items(article.value, key = { it.id_artikel }) {
                ArticleItem(article = it) { articleId ->
                    navController.navigate("detail_article/$articleId")
                }
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