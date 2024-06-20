package com.sukasrana.peka.presentation.mkia.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.sukasrana.peka.R
import com.sukasrana.peka.model.Mkia
import com.sukasrana.peka.navigation.Screen
import com.sukasrana.peka.ui.theme.PekaTheme

@Composable
fun MkiaItem(
    mkia: Mkia,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .width(360.dp)
            .background(MaterialTheme.colorScheme.primary)
            .clickable {
                onItemClicked(mkia.id_mkia)
            }
    ) {
        Image(
            painter = rememberImagePainter(mkia.image),
            contentScale = ContentScale.Crop,
            contentDescription = mkia.title,
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp))
        Text(
            text = mkia.title,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.padding(start = 10.dp))
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun MkiaItemPreview() {
//    PekaTheme {
//        MkiaItem(
//            mkia = Mkia(
//                1, "Ttile Title Title", 1, "Description", R.drawable.image_kehamilansehat_mkia
//            ),
//            onItemClicked = { mkiaId ->
//                println("Id Mkia = $mkiaId")
//            }
//        )
//    }
//}