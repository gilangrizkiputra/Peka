package com.sukasrana.peka.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sukasrana.peka.data.ListData
import com.sukasrana.peka.model.MpasiModel
import com.sukasrana.peka.ui.theme.bodyFontFamily

@Composable
fun DetailMpasi(
    modifier: Modifier = Modifier,
    navController: NavController,
    mpasiId: Int?
) {
    val newMpasi = ListData.TheMpasi.filter { mpasi ->
        mpasi.id == mpasiId
    }
    DetailMpasiContent(newMpasiList = newMpasi)
}

@Composable
private fun DetailMpasiContent(
    newMpasiList: List<MpasiModel>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = newMpasiList[0].photo)
                    .build(),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(height = 250.dp, width = 366.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentDescription = "Poster Movie"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.padding(top = 16.dp)) {
            Text(
                text = stringResource(id = newMpasiList[0].nama),
                fontFamily = bodyFontFamily,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                text = stringResource(id = newMpasiList[0].gizi),
                fontFamily = bodyFontFamily,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            )
            Text(
                text = stringResource(id = newMpasiList[0].bahan),
                fontFamily = bodyFontFamily,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal
                )
            )
            Text(
                text = stringResource(id = newMpasiList[0].caramemasak),
                fontFamily = bodyFontFamily,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Justify
                ),
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailMapContentPreview() {
    DetailMpasiContent(newMpasiList = ListData.TheMpasi)
}