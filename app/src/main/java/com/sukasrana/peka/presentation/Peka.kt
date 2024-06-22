package com.sukasrana.peka.presentation

import androidx.activity.ComponentActivity
import com.sukasrana.peka.presentation.login.LoginScreen
import com.sukasrana.peka.presentation.login.SignUpScreen
import com.sukasrana.peka.presentation.login.SwitchScreen
import com.sukasrana.peka.presentation.onboarding.OnBoardingScreen
import com.sukasrana.peka.presentation.splash.SplashScreen
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.sukasrana.peka.data.SharedPreferenceManager
import com.sukasrana.peka.network.maps.LocationHelper
import com.sukasrana.peka.presentation.PendaftaranOnline.PendaftaranOnlineScreen
import com.sukasrana.peka.presentation.addFormChild.AddFormChildScreen
import com.sukasrana.peka.presentation.cekNoAntrian.CekNoAntrianScreen
import com.sukasrana.peka.presentation.graphic.GraphicScreen
import com.sukasrana.peka.presentation.mkia.MkiaScreen
import com.sukasrana.peka.presentation.mkia.MkiaDetail
import com.sukasrana.peka.presentation.profile.AboutScreen
import com.sukasrana.peka.presentation.profile.FeedbackScreen
import com.sukasrana.peka.presentation.profile.ProfileEditScreen
import com.sukasrana.peka.presentation.profile.ProfileScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Peka(
    locationHelper: LocationHelper,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    val nav = remember { mutableStateOf("") }
    val title = remember { mutableStateOf("") }
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route


    Scaffold(
        bottomBar = {
            if (nav.value == "no_bot" || nav.value == "no_top_no_bot") {
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
                nav.value = "no_top_no_bot"
                SplashScreen(navController = navController)
            }

            composable(Screen.OnBoarding.route) {
                nav.value = "no_top_no_bot"
                OnBoardingScreen(navController = navController)
            }

            composable(Screen.Switch.route) {
                nav.value = "no_top_no_bot"
                SwitchScreen(navController = navController)
            }

            composable(Screen.Login.route) {
                nav.value = "no_top_no_bot"
                LoginScreen(navController = navController, locationHelper = locationHelper)
            }

            composable(Screen.Signup.route) {
                nav.value = "no_top_no_bot"
                SignUpScreen(navController = navController)
            }

            composable(Screen.Home.route) {
                nav.value = "no_top"
                HomeScreen(navController)
            }

            composable(Screen.Article.route) {
                nav.value = "no_top"
                ArticleScreen(navController)
            }

            composable(Screen.DetailArticle.route + "/{articleId}",
                arguments = listOf(navArgument("articleId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailArticle(
                    navController = navController,
                    articleId = navBackStackEntry.arguments?.getInt("articleId")
                )
                nav.value = "no_bot"
            }

            composable(Screen.Mpasi.route) {
                nav.value = "no_bot"
                MpasiScreen(navController)
            }

            composable(Screen.DetailMpasi.route + "/{mpasiId}",
                arguments = listOf(navArgument("mpasiId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailMpasi(
                    navController = navController,
                    mpasiId = navBackStackEntry.arguments?.getInt("mpasiId")
                )
                nav.value = "no_bot"
            }

            composable(Screen.Balita.route+ "/{balitaId}",
                arguments = listOf(navArgument("balitaId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                nav.value = "no_bot"
                GraphicScreen(
                    navController,
                    balitaId = navBackStackEntry.arguments?.getInt("balitaId")
                )
            }

            composable(Screen.Mkia.route) {
                nav.value = "no_top"
                MkiaScreen(navController)
            }

            composable(
                Screen.MkiaDetail.route + "/{mkiaId}",
                arguments = listOf(navArgument("mkiaId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                MkiaDetail(
                    navController = navController,
                    mkiaId = navBackStackEntry.arguments?.getInt("mkiaId")
                )
                nav.value = "no_bot"
            }

            composable(Screen.Profile.route) {
                nav.value = "no_top"
                ProfileScreen(navController)
            }
            composable(Screen.About.route) {
                nav.value = "no_bot"
                title.value = "Tentang Alikasi"
                AboutScreen(navController)
            }
            composable(Screen.ProEdit.route) {
                nav.value = "no_bot"
                title.value = "Atur Profil Anda"
                ProfileEditScreen(navController, userId = 1 )
            }
            composable(Screen.Feedback.route) {
                nav.value = "no_bot"
                title.value = "Bantuan dan Laporan "
                FeedbackScreen(navController)
            }
            composable(Screen.Notification.route) {
                nav.value = "no_bot"
                NotificationScreen(navController) { }
            }
            composable(Screen.TambahIdentitasAnak.route) {
                nav.value = "no_bot"
                AddFormChildScreen(navController)
            }
            composable(Screen.PendaftaranOnlineAnak.route) {
                nav.value = "no_bot"
                PendaftaranOnlineScreen(navController)
            }
            composable(Screen.CekNoAntrian.route) {
                nav.value = "no_bot"
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
            .height(80.dp),
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
                },
                label = {
                    Text(
                        text = item.title,
                        color = Color.Gray
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PekaAppPrev() {
    Peka(locationHelper = LocationHelper(LocalContext.current as ComponentActivity))
}