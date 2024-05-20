package com.sukasrana.peka.presentation

import com.sukasrana.peka.presentation.login.LoginScreen
import com.sukasrana.peka.presentation.login.SignUpScreen
import com.sukasrana.peka.presentation.login.SwitchScreen
import com.sukasrana.peka.presentation.onboarding.OnBoardingScreen
import com.sukasrana.peka.presentation.splash.SplashScreen
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.R
import com.sukasrana.peka.navigation.NavigationItem
import com.sukasrana.peka.navigation.Screen
import com.sukasrana.peka.presentation.home.HomeScreen
import com.sukasrana.peka.presentation.notification.NotificationScreen
import com.sukasrana.peka.ui.theme.primaryColor
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.sukasrana.peka.presentation.PendaftaranOnline.PendaftaranOnlineScreen
import com.sukasrana.peka.presentation.addFormChild.AddFormChildScreen
import com.sukasrana.peka.presentation.cekNoAntrian.CekNoAntrianScreen
import com.sukasrana.peka.presentation.graphic.GraphicScreen
import com.sukasrana.peka.ui.theme.bodyFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Peka(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    val title = remember { mutableStateOf("") }
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route


    Scaffold(
        topBar = {
            if (title.value == "Home" || title.value == "Article" || title.value == "MKIA" || title.value == "Profile" || title.value == "splashscreen" || title.value == "onboarding" || title.value == "switch" || title.value == "login" || title.value == "signup" || title.value == "Cek No Antrian") {
                println("")
            } else {
                TopAppBar(
                    title = {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            if (title.value == "Notifikasi" || title.value == "Tambah Identitas Anak" || title.value == "Pantau Tumbuh Kembang Anak" || title.value == "Pendaftaran Online") {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Back",
                                    modifier = Modifier
                                        .clickable { navController.navigateUp() }
                                        .padding(top = 16.dp,)
                                )
                                Spacer(modifier = Modifier.padding(top = 16.dp))
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(end = 16.dp)
                                ) {
                                    Text(
                                        text = title.value,
                                        fontFamily = bodyFontFamily,
                                        style = MaterialTheme.typography.bodyLarge.copy(
                                            fontSize = 19.sp,
                                            fontWeight = FontWeight.Bold
                                        ),
                                        color = Color.Black,
                                    )
                                }
                            }
                        }
                    },
                    modifier = Modifier.height(100.dp)
                )
            }
        },
        bottomBar = {
            if (title.value == "Notifikasi" || title.value == "Tambah Identitas Anak" || title.value == "Pantau Tumbuh Kembang Anak" || title.value == "Pendaftaran Online" || title.value == "splashscreen" || title.value == "onboarding" || title.value == "switch" || title.value == "login" || title.value == "signup" || title.value == "Cek No Antrian" || title.value == "Balita") {
                println("")
            } else {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.Splash.route) {
                title.value = "splashscreen"
                SplashScreen(navController = navController)
            }

            composable(Screen.OnBoarding.route) {
                title.value = "onboarding"
                OnBoardingScreen(navController = navController)
            }

            composable(Screen.Switch.route) {
                title.value = "switch"
                SwitchScreen(navController = navController)
            }

            composable(Screen.Login.route) {
                title.value = "login"
                LoginScreen(navController = navController)
            }

            composable(Screen.Signup.route) {
                title.value = "signup"
                SignUpScreen(navController = navController)
            }

            composable(Screen.Home.route) {
                title.value = "Home"
                HomeScreen(navController)
            }

            composable(Screen.Article.route) {
                title.value = "Article"
                ArticleScreen(navController)
            }

            composable(Screen.Balita.route) {
                title.value = "Balita"
                GraphicScreen(navController)
            }

            composable(Screen.Mkia.route) {
                title.value = "MKIA"
                HomeScreen(navController)
            }
            composable(Screen.Profile.route) {
                title.value = "Profile"
                HomeScreen(navController)
            }
            composable(Screen.Notification.route) {
                title.value = "Notifikasi"
                NotificationScreen(navController) { }
            }
            composable(Screen.TambahIdentitasAnak.route) {
                title.value = "Tambah Identitas Anak"
                AddFormChildScreen(navController)
            }
            composable(Screen.PendaftaranOnlineAnak.route) {
                title.value = "Pendaftaran Online"
                PendaftaranOnlineScreen(navController)
            }
            composable(Screen.CekNoAntrian.route) {
                title.value = "Cek No Antrian"
                CekNoAntrianScreen(navController)
            }
        }
    }
}
@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
            .height(60.dp),
        containerColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = painterResource(id = R.drawable.ic_home),
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_article),
                icon = painterResource(id = R.drawable.ic_artikel),
                screen = Screen.Article
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_mkia),
                icon = painterResource(id = R.drawable.ic_mkia),
                screen = Screen.Mkia
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_profile),
                icon = painterResource(id = R.drawable.ic_profile),
                screen = Screen.Profile
            ),
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                colors = androidx.compose.material3.NavigationBarItemDefaults
                    .colors(
                        indicatorColor = primaryColor
                    ),
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.title,
                        tint = if (currentRoute == item.screen.route) Color.White else Color.Gray
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PekaAppPrev() {
    Peka()
}
