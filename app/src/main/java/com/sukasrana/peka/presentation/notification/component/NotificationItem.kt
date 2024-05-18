package com.sukasrana.peka.presentation.notification.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sukasrana.peka.ui.theme.bodyFontFamily

@Composable
fun NotificationItem(
    modifier: Modifier = Modifier,
    //onItemClicked: (Int) -> Unit
) {
    Surface(
        modifier = modifier
            .width(360.dp),
            //.clickable { onItemClicked(rumahAdat.id) },
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 4.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                //.clickable { onItemClicked(rumahAdat.id) }
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "notifikasi item",
                modifier = Modifier
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "13/01/2024" ,
                    fontFamily = bodyFontFamily,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 8.sp, fontWeight = FontWeight.Normal),
                    color = Color.Black,
                )
                Text(
                    text = "Ayo ambil antrian posyandu!" ,
                    fontFamily = bodyFontFamily,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp, fontWeight = FontWeight.SemiBold),
                    color = Color.Black,
                )
                Text(
                    text = "Akan diadakan posyandu pada tanggal..." ,
                    fontFamily = bodyFontFamily,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 7.sp, fontWeight = FontWeight.Normal),
                    color = Color.Black,
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Detail" ,
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 10.sp, fontWeight = FontWeight.Normal),
                        color = Color.Black,
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "detail",
                        modifier = Modifier
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NotificationItemPreview() {
    NotificationItem()
}