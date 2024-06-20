package com.sukasrana.peka.presentation.mkia


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sukasrana.peka.data.repository.fetchMkia
import com.sukasrana.peka.model.Mkia
import com.sukasrana.peka.ui.theme.bodyFontFamily

@Composable
fun MkiaDetail(
    navController: NavController,
    modifier: Modifier = Modifier,
    mkiaId: Int?
) {
    val mkia = remember { mutableStateOf<Mkia?>(null) }

    LaunchedEffect(mkiaId) {
        mkia.value = fetchMkia()?.find { it.id_mkia == mkiaId }
    }

    mkia.value?.let {
        MkiaContent(navController, newMkiaList = it)
    } ?: run {
        Text(
            text = "Loading...",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = modifier.padding(16.dp)
        )
    }
}

@Composable
private fun MkiaContent(
    navController: NavController,
    modifier: Modifier = Modifier,
    newMkiaList: Mkia
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        IconButton(
            onClick = { navController.navigateUp() },
            modifier = modifier
                .padding(top = 7.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                modifier = modifier
                    .size(30.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = newMkiaList.image)
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
                text = newMkiaList.title,
                fontFamily = bodyFontFamily,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                text = newMkiaList.content,
                fontFamily = bodyFontFamily,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Justify
                ),
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "Sumber : ${newMkiaList.sumber}",
                fontFamily = bodyFontFamily,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier.padding(top = 16.dp)

            )
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//private fun DetailMapContentPreview() {
//    MkiaContent(navController = rememberNavController(),newMkiaList = ListData.listMkia)
//}