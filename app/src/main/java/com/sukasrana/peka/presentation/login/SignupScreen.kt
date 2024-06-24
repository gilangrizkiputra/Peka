package com.sukasrana.peka.presentation.login

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.R
import com.sukasrana.peka.model.User
import com.sukasrana.peka.navigation.Screen
import com.sukasrana.peka.network.RetrofitInstance
import com.sukasrana.peka.presentation.component.EmailTextField
import com.sukasrana.peka.presentation.component.NameTextField
import com.sukasrana.peka.presentation.component.PasswordTextField
import com.sukasrana.peka.ui.theme.PekaTheme
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

@Composable
fun SignUpScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }

    var noKk by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var konfirmPassword by remember {
        mutableStateOf("")
    }

    fun onDaftarClick() {
        if (name.isEmpty() || email.isEmpty() || noKk.isEmpty() || password.isEmpty() || konfirmPassword.isEmpty()){
            Toast.makeText(context, "Data belum lengkap", Toast.LENGTH_LONG).show()
            return
        }
        if (password != konfirmPassword){
            Toast.makeText(context, "Password dan Konfirmasi Password Berbeda", Toast.LENGTH_LONG).show()
            return
        }

        val user = User(
            id_user = null,
            nama = name,
            email = email,
            password = password,
            nik = noKk.toLong(),
            alamat = "",
            authority = "user",
            foto_profile = ""
        )
        Log.d("UserData", "Data yang dikirim: $user")

        coroutineScope.launch {
            try {
                val response = RetrofitInstance.api.addUser(user)
                if (response.isSuccessful) {
                    Log.d("UserData", "Daftar berhasil")
                    Toast.makeText(context, "Daftar Berhasil", Toast.LENGTH_LONG).show()
                    navController.navigate(Screen.Login.route)
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.d("UserData", "Server Error: $errorBody")
                    Toast.makeText(context, "Server Error: $errorBody", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                when (e) {
                    is IOException -> {
                        Log.d("UserData", "Network Error: ${e.message}")
                        Toast.makeText(context, "Network Error: ${e.message}", Toast.LENGTH_LONG).show()
                    }
                    is HttpException -> {
                        val code = e.code()
                        val errorResponse = e.response()?.errorBody()?.string()
                        Log.d("UserData", "HTTP Error: Code $code, $errorResponse")
                        Toast.makeText(context, "HTTP Error: Code $code", Toast.LENGTH_LONG).show()
                    }
                    else -> {
                        Log.d("UserData", "Unknown Error: ${e.message}")
                        Toast.makeText(context, "Unknown Error: ${e.message}", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    IconButton(
        onClick = { navController.navigateUp() },
        modifier = modifier
            .padding(start = 10.dp, top = 20.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            modifier = modifier
                .size(25.dp)
        )
    }

    SignupContent(
        name = name,
        email = email,
        noKk = noKk,
        password = password,
        konfirmPassword = konfirmPassword,
        onNameChange = {name = it},
        onEmailChange = {email = it},
        onNoKkChange = {noKk = it},
        onPasswordChange = {password = it},
        onKonfirmPasswordChange = {konfirmPassword = it},
        moveToLogin = {
            navController.navigate(Screen.Login.route)
        },
        onRegisterClick = {onDaftarClick()})

}


@Composable
fun SignupContent(
    name: String,
    email: String,
    noKk: String,
    password: String,
    konfirmPassword: String,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onNoKkChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onKonfirmPasswordChange: (String) -> Unit,
    moveToLogin: () -> Unit,
    onRegisterClick: () -> Unit,
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
            }
    )
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
                text = "Daftar",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.padding(top = 16.dp))
            Text(text = "Nama")
            NameTextField(
                value = name,
                onValueChange = onNameChange,
                label = "Nama"
            )
            Text(text = "Email")
            EmailTextField(
                value = email,
                onValueChange = onEmailChange,
                label = "Email"
            )
            Text(text = "Nomor KK (Kartu Keluarga)")
            EmailTextField(
                value = noKk,
                onValueChange = onNoKkChange,
                label = "Nomor Kartu Keluarga"
            )
            Text(text = "Kata Sandi")
            PasswordTextField(
                text = password,
                onValueChange = onPasswordChange,
                label = "Kata Sandi"
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(text = "Konfirmasi Kata Sandi")
            PasswordTextField(
                text = konfirmPassword,
                onValueChange = onKonfirmPasswordChange,
                label = "Konfirmasi Kata Sandi"
            )
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Sudah punya akun?",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(top = 16.dp, bottom = 16.dp)
                )
                TextButton(
                    onClick = moveToLogin,
                    modifier = Modifier
                        .padding(bottom = 1.dp)
                ) {
                    Text(
                        text = "Klik Disini",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Button(
                onClick = onRegisterClick,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .height(48.dp)
            ) {
                Text(
                    text = "Daftar",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview(){
    PekaTheme {
        SignUpScreen(navController = rememberNavController())
    }
}