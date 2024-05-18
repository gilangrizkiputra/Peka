package com.sukasrana.peka.presentation.login

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.R
import com.sukasrana.peka.navigation.Screen
import com.sukasrana.peka.presentation.login.component.EmailTextField
import com.sukasrana.peka.presentation.login.component.PasswordTextField
import com.sukasrana.peka.ui.theme.PekaTheme

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    LoginContent(
        email = "",
        password = "",
        onEmailChange = { email = it },
        onPasswordChange = { password = it },
        moveToForgot = {
            Toast.makeText(
                context,
                "Silahkan di kembangkan sendiri",
                Toast.LENGTH_SHORT
            ).show()
                       },
        moveToSignUp = {
            navController.navigate(Screen.Signup.route)
        },
        onLoginClick = {
            Toast.makeText(
                context,
                "Silahkan di kembangkan sendiri",
                Toast.LENGTH_SHORT
            ).show()
        },
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
                .padding(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview(){
    PekaTheme {
        LoginScreen(navController = rememberNavController())
    }
}