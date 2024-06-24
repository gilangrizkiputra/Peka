package com.sukasrana.peka.presentation.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.R
import com.sukasrana.peka.navigation.Screen
import com.sukasrana.peka.ui.theme.PekaTheme
import com.sukasrana.peka.ui.theme.bodyFontFamily

@Composable
fun AddBalitaItem(
    navController: NavController,
    modifier: Modifier = Modifier,
)
{
    val stroke = Stroke(width = 10f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    )

    Surface(
        modifier = modifier
            .clickable {
                navController.navigate(Screen.TambahIdentitasAnak.route)
            }
            .drawBehind {
                drawRoundRect(
                    color = Color.Black,
                    style = stroke,
                    cornerRadius = CornerRadius(10.dp.toPx())
                )
            },
        color = Color.LightGray,
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(size = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .width(102.dp)
                .height(89.dp)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_plus_balita_beranda),
                contentDescription = "add balita",
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Tambah Identitas\n anak",
                fontFamily = bodyFontFamily,
                style = MaterialTheme.typography.bodyLarge.copy(
                    textAlign = TextAlign.Center,
                    lineHeight = 11.2.sp,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Normal),
                color = Color.Black,
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BalitaItemHorizontalPreview() {
    PekaTheme {
        AddBalitaItem(navController = rememberNavController())
//            onItemClicked = { balitaId ->
//                println("Balita Id : $balitaId")
//            }
    }
}