package com.sukasrana.peka.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sukasrana.peka.R
import com.sukasrana.peka.model.Article
import com.sukasrana.peka.ui.theme.PekaTheme
import com.sukasrana.peka.ui.theme.bodyFontFamily

@Composable
fun ArticleItem(
    article: Article,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clickable {
                onItemClicked(article.id)
            }
            .fillMaxWidth()
            .padding(start = 16.dp) // Menambahkan margin 16dp di sekeliling keseluruhan item
            .width(360.dp)
            .height(104.dp)
    ) {
        Image(
            painter = painterResource(id = article.photo),
            contentDescription ="${stringResource(id = article.title)}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(113.dp, 72.dp) // Mengatur ukuran gambar
        )

        Column (
            modifier = Modifier
                .padding(start = 8.dp) // Margin yang diminta
        ){
            Text(
                text = "${stringResource(id = article.title)}",
                fontFamily = bodyFontFamily,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = article.date,
                fontFamily = bodyFontFamily,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 8.sp, fontWeight = FontWeight.Normal)

            )


        }

    }



}


@Preview(showBackground = true)
@Composable
private fun ArticleItemPreview() {
    PekaTheme {
        ArticleItem(
            article = Article(1, R.string.titleArticle1, R.string.contentArticle1, "12 Januari 2024", R.drawable.image_artikel1),
            onItemClicked = { articleId ->
                println("Article Id : $articleId")
            }
        )
    }
}
