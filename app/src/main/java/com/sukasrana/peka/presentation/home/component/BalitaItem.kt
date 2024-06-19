package com.sukasrana.peka.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sukasrana.peka.R
import com.sukasrana.peka.model.Balita
import com.sukasrana.peka.ui.theme.PekaTheme
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.navigation.Screen
import com.sukasrana.peka.ui.theme.provider
import com.sukasrana.peka.ui.theme.secondaryTreeColor
import com.sukasrana.peka.ui.theme.secondaryTwoColor
import com.sukasrana.peka.ui.theme.bodyFontFamily

@Composable
fun BalitaItem(
    navController: NavController,
    modifier: Modifier = Modifier,
    balita: Balita,
    //zonItemClicked: (Int) -> Unit
)
{
    val font = GoogleFont("Poppins")
    val fontFamily = FontFamily(
        Font(
            googleFont = font,
            fontProvider = provider,
            weight = FontWeight.Bold,
            style = FontStyle.Italic
        )
    )
    Surface(
        modifier = modifier
            //.clickable { onItemClicked(balita.id) }
            .clickable { navController.navigate(Screen.Balita.route) }
            .width(235.dp),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(size = 10.dp)
    ) {
        Box(
            modifier = Modifier){
            Surface(
                modifier = modifier
                    .padding(0.dp)
                    .width(235.dp)
                    .height(22.dp),
                color = secondaryTreeColor,
            ) {

            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(0.dp)
        ) {
            Box(
                modifier = Modifier
            ){
                Surface(
                    modifier = modifier
                        .padding(0.dp)
                        .width(82.dp)
                        .height(89.dp),
                    color = secondaryTwoColor,
                    shape = RoundedCornerShape(size = 10.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.image_balita_beranda),
                        contentDescription = "",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = balita.nama,
                    fontFamily = bodyFontFamily,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp, fontWeight = FontWeight.SemiBold),
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .width(140.dp)
                        .padding(top = 16.dp),
                    maxLines = 1
                )
//                Text(
//                    text = "${balita.umur} Tahun",
//                    fontFamily = bodyFontFamily,
//                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 11.sp, fontWeight = FontWeight.Normal),
//                    color = Color.Black,
//                    modifier = Modifier.width(140.dp),
//                    maxLines = 1
//                )
            }
        }
    }
}

//@Preview
//@Composable
//private fun BalitaItemHorizontalPreview() {
//    PekaTheme {
//        BalitaItem(balita = Balita(
//            1,
//            321001001001,
//            3211505240016,
//            "Asep Knalpot",
//            "15-05-24",
//            "15-05-24",
//            2,
//            "A",
//            "Laki-laki",
//        ), navController = rememberNavController()
////            onItemClicked = { balitaId ->
////                println("Balita Id : $balitaId")
////            }
//        )
//    }
//}