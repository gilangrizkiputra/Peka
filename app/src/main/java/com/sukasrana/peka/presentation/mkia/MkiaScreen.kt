package com.sukasrana.peka.presentation.mkia

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sukasrana.peka.data.ListData
import com.sukasrana.peka.model.Mkia
import com.sukasrana.peka.presentation.mkia.component.MkiaItem
import com.sukasrana.peka.ui.theme.PekaTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MkiaContent(
    modifier: Modifier = Modifier,
    mkia: List<Mkia> = ListData.listMkia
) {
    val tabItems = listOf(
        TabItems("Kesehatan Ibu", "ibu"),
        TabItems("Kesehatan Anak", "anak")
    )
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val pagerState = rememberPagerState {
        tabItems.size
    }
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage) {
        selectedTabIndex = pagerState.currentPage
    }

    val filterdMkia = mkia.filter { it.category == pagerState.currentPage}
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxSize()
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Text(
                text = "Materi KIA",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
                modifier = Modifier.padding(16.dp)
            )
        }
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabItems.forEachIndexed { index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        Text(
                            text = item.title,
                            color = if (index == selectedTabIndex) {
                                MaterialTheme.colorScheme.primary
                            } else Color.Gray
                        )
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                items(filterdMkia, key = { it.id }){
                    MkiaItem(
                        mkia = it,
                        modifier = modifier.padding(bottom = 10.dp))
                }
            }
        }
    }
}

data class TabItems(
    val title: String,
    val kategori: String
)

@Preview(showBackground = true)
@Composable
private fun MkiaScreenPreview() {
    PekaTheme {
        MkiaContent()
    }
}