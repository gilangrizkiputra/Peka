package com.sukasrana.peka.presentation.login


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.R
import com.sukasrana.peka.data.SharedPreferenceManager
import com.sukasrana.peka.navigation.Screen
import com.sukasrana.peka.ui.theme.PekaTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SwitchScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current
    val preferencesManager = remember {
        SharedPreferenceManager(context)
    }
    val selectRegisterOrLogin = remember {
        preferencesManager.isSelectRegisterOrLogin()
    }

    LaunchedEffect(selectRegisterOrLogin) {
        if (selectRegisterOrLogin) {
            navController.navigate(Screen.Login.route) {
                popUpTo(0) { inclusive = true }
            }
        }
    }

    if (!selectRegisterOrLogin){
        preferencesManager.setSelectRegisterOrLogin(true)
        Scaffold {
            Column(modifier = modifier.padding(it))
            {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom,
                    modifier = modifier
                        .fillMaxWidth()
                        .weight(0.7f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_login_regis),
                        contentDescription = "Logo Peka",
                        modifier = Modifier
                            .padding(20.dp)
                    )
                    Spacer(modifier = Modifier.padding(100.dp))
                    Button(
                        onClick = {
                            navController.navigate(Screen.Login.route)
                        },
                        modifier = Modifier
                            .padding(16.dp, 5.dp)
                            .fillMaxWidth()
                            .height(44.dp)
                            .clip(MaterialTheme.shapes.extraLarge)
                    ) {
                        Text(
                            text = "Log In",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    Button(
                        onClick = {
                            navController.navigate(Screen.Signup.route)
                        },
                        modifier = Modifier
                            .padding(16.dp, 5.dp, 16.dp, 16.dp)
                            .fillMaxWidth()
                            .height(44.dp)
                            .clip(MaterialTheme.shapes.extraLarge)
                    ) {
                        Text(
                            text = "Sign In",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SwitchScreenPreview(){
    PekaTheme {
        SwitchScreen(navController = rememberNavController())
    }
}