package com.sukasrana.peka.presentation.onboarding

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.R
import com.sukasrana.peka.data.OnBoardingData
import com.sukasrana.peka.data.SharedPreferenceManager
import com.sukasrana.peka.model.OnBoardingItem
import com.sukasrana.peka.navigation.Screen
import com.sukasrana.peka.ui.theme.PekaTheme
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current
    val preferencesManager = remember {
        SharedPreferenceManager(context)
    }
    val onboardingCompleted = remember {
        preferencesManager.isOnboardingCompleted()
    }

    LaunchedEffect(onboardingCompleted) {
        if (onboardingCompleted) {
            navController.navigate(Screen.Switch.route) {
                popUpTo(0) { inclusive = true }
            }
        }
    }

    if (!onboardingCompleted) {
        val onBoardings = OnBoardingData.onBoardingItems

        OnBoardingContent(
            onBoardings = onBoardings,
            moveToSwitch = {
                preferencesManager.setOnboardingCompleted(true)
                navController.navigate(Screen.Switch.route) {
                    popUpTo(Screen.OnBoarding.route) {
                        inclusive = true
                    }
                }
            },
            modifier = modifier
        )
    }
}

@SuppressLint("ResourceType")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingContent(
    onBoardings: List<OnBoardingItem>,
    moveToSwitch: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { onBoardings.size })
    val (selectedPage, setSelectedPage) = remember { mutableIntStateOf(0) }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page -> setSelectedPage(page) }
    }

    Scaffold {
        Column(modifier = modifier.padding(it)) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(0.6f)
            ) { page ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {
                    Box{
                        Image(
                            painter = painterResource(id = R.drawable.image_onboarding_background),
                            contentDescription = "BG_OnBoarding",
                            modifier = Modifier.offset(x = (-70).dp, y = (-145).dp)
                        )
                        Image(
                            painter = painterResource(id = onBoardings[page].resId),
                            contentDescription = "OnBoarding Picture"
                        )
                    }
                    Text(
                        text = onBoardings[page].title,
                        style = MaterialTheme.typography.titleLarge,

                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(11.dp))
                    Text(
                        text = onBoardings[page].description,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                for (i in onBoardings.indices) {
                    Box(
                        modifier = Modifier
                            .padding(end = if (i == onBoardings.size - 1) 0.dp else 5.dp)
                            .width(if (i == selectedPage) 20.dp else 10.dp)
                            .height(10.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                if (i == selectedPage) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary.copy(
                                    alpha = 0.1f
                                )
                            )
                    )
                }
            }

            if (selectedPage != onBoardings.size - 1) {
                Button(
                    onClick = {
                        scope.launch {
                            val nextPage = selectedPage + 1
                            pagerState.animateScrollToPage(nextPage)
                        }
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(44.dp)
                        .clip(MaterialTheme.shapes.extraLarge)
                ) {
                    Text(
                        text = "Lanjut",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            if (selectedPage == onBoardings.size - 1) {
                Button(
                    onClick = {
                        moveToSwitch()
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(44.dp)
                        .clip(MaterialTheme.shapes.extraLarge)
                ) {
                    Text(
                        text = "Lanjut",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OnBoardingPrivew(){
    PekaTheme {
        OnBoardingScreen(navController = rememberNavController())
    }
}