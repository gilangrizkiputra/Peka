package com.sukasrana.peka.presentation.login

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sukasrana.peka.R
import com.sukasrana.peka.data.SharedPreferenceLogin
import com.sukasrana.peka.model.LoginRequest
import com.sukasrana.peka.navigation.Screen
import com.sukasrana.peka.network.RetrofitInstance
import com.sukasrana.peka.network.maps.LocationHelper
import com.sukasrana.peka.presentation.component.EmailTextField
import com.sukasrana.peka.presentation.component.PasswordTextField
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun LoginScreen(
    navController: NavController,
    locationHelper: LocationHelper,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val preferencesManager = remember {
        SharedPreferenceLogin(context)
    }

    LaunchedEffect(Unit) {
        if (preferencesManager.isLoggedIn &&
            !preferencesManager.email.isNullOrBlank() &&
            !preferencesManager.password.isNullOrBlank()
        ) {
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Login.route) { inclusive = true }
            }
        }
    }

    fun login() {
        coroutineScope.launch {
            try {
                val loginRequest = LoginRequest(email, password)
                Log.d("LoginRequest", "Request: $loginRequest")

                val response = RetrofitInstance.api.loginUser(loginRequest)
                Log.d("LoginResponse", "Response: ${response.isSuccessful}, Body: ${response.body()}")

                if (email.isEmpty() && password.isEmpty()){
                    Toast.makeText(context, "Mohon isi form login", Toast.LENGTH_SHORT).show()
                }else{
                    withContext(Dispatchers.Main) {
                        if (response.isSuccessful && response.body() != null) {
                            val loginResponse = response.body()!!
                            if (loginResponse.success && loginResponse.data.id_user != null) {
                                val user = loginResponse.data
                                Log.d("LoginResponse", "User: $user")

                                val sharedPref = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                                with(sharedPref.edit()) {
                                    user.id_user?.let { putInt("USER_ID", it) }
                                    apply()
                                }

                                preferencesManager.email = email
                                preferencesManager.password = password
                                preferencesManager.isLoggedIn = true

                                Toast.makeText(context, "Login berhasil!", Toast.LENGTH_SHORT).show()

                                navController.navigate(Screen.Home.route) {
                                    popUpTo(Screen.Login.route) { inclusive = true }
                                }
                                locationHelper.checkPermissionsAndStartLocationUpdate()
                            } else {
                                Log.e("LoginError", "Login tidak berhasil: ${loginResponse.success}")
                                Toast.makeText(context, "Login gagal. Data pengguna tidak valid.", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Log.e("LoginError", "Response: ${response.code()} - ${response.message()}")
                            Toast.makeText(context, "Email atau Password salah", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("LoginError", "Exception: ${e.localizedMessage}")
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Login gagal. Silakan coba lagi.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    IconButton(
        onClick = { navController.navigateUp() },
        modifier = modifier
            .padding(start = 10.dp, top = 70.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            modifier = modifier
                .size(25.dp)
        )
    }

    LoginContent(
        email = email,
        password = password,
        onEmailChange = { email = it },
        onPasswordChange = { password = it },
        moveToForgot = {
            Toast.makeText(
                context,
                "Fitur belum tersedia",
                Toast.LENGTH_SHORT
            ).show()
        },
        moveToSignUp = {
            navController.navigate(Screen.Signup.route)
        },
        onLoginClick = { login() },
        modifier = modifier
    )
}

@Composable
fun LoginContent(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    moveToForgot: () -> Unit,
    moveToSignUp: () -> Unit,
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState()
) {
    Image(
        painter = painterResource(id = R.drawable.image_onboarding_background),
        contentDescription = "OnBoarding BG",
        modifier = modifier
            .offset(x = 210.dp, y = (-90).dp)
            .graphicsLayer {
                this.rotationZ = 120f
            })
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            Text(
                text = "Masuk",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Text(text = "Email")
            EmailTextField(
                value = email,
                onValueChange = onEmailChange,
                label = "Email"
            )
            Text(text = "Kata Sandi")
            PasswordTextField(
                text = password,
                onValueChange = onPasswordChange,
                label = "Password"
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextButton(
                    onClick = moveToForgot,
                    modifier = Modifier
                        .padding(bottom = 1.dp)
                ) {
                    Text(
                        text = "Lupa Kata Sandi?",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Row(horizontalArrangement = Arrangement.End) {

                    Text(
                        text = "Belum punya akun?",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .padding(top = 16.dp, bottom = 16.dp)
                    )
                    TextButton(
                        onClick = moveToSignUp,
                        modifier = Modifier
                            .padding(bottom = 1.dp)
                    ) {
                        Text(
                            text = "Daftar",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
            Button(
                onClick = onLoginClick,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .height(48.dp)
            ) {
                Text(
                    text = "Masuk",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.logo_peka_no_text),
            contentDescription = "Peka Logo No Text",
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun LoginScreenPreview() {
//    val activity = LocalContext.current as ComponentActivity
//    val locationHelper = remember { LocationHelper(activity) }
//    PekaTheme {
//        LoginScreen(navController = rememberNavController(), locationHelper = locationHelper)
//    }
//}