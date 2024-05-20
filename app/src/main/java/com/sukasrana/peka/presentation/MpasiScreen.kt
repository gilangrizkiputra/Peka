package com.sukasrana.peka.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.data.ListData
import com.sukasrana.peka.model.MpasiModel
import com.sukasrana.peka.presentation.component.MpasiItem
import com.sukasrana.peka.ui.theme.bodyFontFamily
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf



@Composable
fun MpasiScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    mpasi: List<MpasiModel> = ListData.TheMpasi,
) {
    // State to hold the current category
    var selectedCategory by remember { mutableStateOf("semua") }

    // Filter the list based on the selected category
    val filteredMpasi = when (selectedCategory) {
        "6-8 Bulan" -> mpasi.filter { it.bulan == 6 }
        "9-11 Bulan" -> mpasi.filter { it.bulan == 8 }
        "12 Bulan >" -> mpasi.filter { it.bulan == 9 }
        else -> mpasi
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.background(Color.White)
    ) {

        item {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Kembali"
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 4.dp, end = 16.dp)
                        .weight(1f)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Makanan Pendamping ASI",
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 19.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }
        }

        // Adding the navigation buttons
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedButton(
                    onClick = { selectedCategory = "Semua" },
                    modifier = Modifier
                        .weight(1f)
                        .size(76.dp, 30.dp)
                ) {
                    Text(
                        text = "Semua",
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                OutlinedButton(
                    onClick = { selectedCategory = "6-8 Bulan" },
                    modifier = Modifier
                        .weight(1f)
                        .size(76.dp, 30.dp)
                ) {
                    Text(
                        text = "6-8 Bulan",
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                OutlinedButton(
                    onClick = { selectedCategory = "9-11 Bulan" },
                    modifier = Modifier
                        .weight(1f)
                        .size(76.dp, 30.dp)
                ) {
                    Text(
                        text = "9-11 Bulan",
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                OutlinedButton(
                    onClick = { selectedCategory = "12 Bulan >" },
                    modifier = Modifier
                        .weight(1f)
                        .size(76.dp, 30.dp)
                ) {
                    Text(
                        text = "12 Bulan >",
                        fontFamily = bodyFontFamily,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
            }
        }

        items(filteredMpasi, key = { it.id }) { item ->
            MpasiItem(mpasi = item) { mpasiId ->
                // navigate to detail map screen
            }
        }
    }
}



@Preview
@Composable
private fun previewMpasiScreen() {
    val navController = rememberNavController()
    MpasiScreen(navController)
}