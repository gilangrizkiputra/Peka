@file:OptIn(ExperimentalMaterial3Api::class)

package com.sukasrana.peka.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.R
import com.sukasrana.peka.presentation.addFormChild.component.TextFieldCustom
import com.sukasrana.peka.presentation.component.NumberTextField
import com.sukasrana.peka.presentation.component.PasswordTextField
import com.sukasrana.peka.ui.theme.PekaTheme

@Composable
fun ProfileEditScreen(
    navController: NavController
) {

    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var number by remember {
        mutableStateOf("")
    }
    var nkk by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var pass by remember {
        mutableStateOf("")
    }

    var isEnable = false
    if (password == pass) isEnable = true

    ProfileEditContent(
        isEnable = isEnable,
        navController = navController,
        name = name,
        email = email,
        number = number,
        nkk = nkk,
        password = password,
        pass = pass,
        onNameChange = { name = it },
        onEmailChange = { email = it },
        onNumbChange = { number = it },
        onNkkChange = { nkk = it },
        onPasswordChange = { password = it },
        onPassChange = { pass = it }
    )
}

@Composable
fun ProfileEditContent(
    isEnable: Boolean,
    name: String,
    email: String,
    number: String,
    nkk: String,
    password: String,
    pass: String,
    onNameChange: (String) -> Unit,
    onNumbChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onNkkChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPassChange: (String) -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val sheetState = rememberModalBottomSheetState()
    val isSheetOpen = rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .shadow(elevation = 1.dp)
        ) {
            IconButton(
                onClick = { navController.navigateUp() },
                modifier = modifier
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = modifier
                        .size(30.dp)
                )
            }
            Text(
                text = "Atur Profile Anda",
                style = MaterialTheme.typography.titleMedium
            )
        }
        Column(
            modifier = modifier
                .padding(15.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .padding(bottom = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image_profile),
                    contentDescription = "Profile",
                    modifier = modifier
                        .padding(end = 10.dp)
                        .clickable { isSheetOpen.value = true }
                )
                Text(
                    text = "Ungah Foto Anda",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Text(text = "Nama")
            TextFieldCustom(
                value = name,
                onValueChange = onNameChange
            )
            Text(text = "Email")
            TextFieldCustom(
                value = email,
                onValueChange = onEmailChange
            )
            Text(text = "Nomor")
            NumberTextField(
                value = number,
                onValueChange = onNumbChange
            )
            Text(text = "Nomor Kartu Keluarga")
            NumberTextField(
                value = nkk,
                onValueChange = onNkkChange
            )
            Text(text = "Kata Sandi")
            PasswordTextField(
                text = password,
                onValueChange = onPasswordChange
            )
            Text(text = "Masukan Ulang Kata Sandi")
            PasswordTextField(
                text = pass,
                onValueChange = onPassChange
            )

            Button(
                onClick = { },
                enabled = isEnable,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .height(44.dp)
            ) {
                Text(
                    text = "Kirim",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }

    if (isSheetOpen.value) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { isSheetOpen.value = false })
        {
            Column(modifier = modifier.padding(bottom = 16.dp, start = 16.dp, end = 16.dp)) {
                Text(
                    text = "Pilih Foto Profile",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = modifier.padding(10.dp))
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(bottom = 30.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_camera),
                        contentDescription = null,
                        modifier = modifier
                            .size(70.dp)
                    )
                    Spacer(modifier = modifier.padding(5.dp))
                    Image(
                        painter = painterResource(id = R.drawable.icon_gallery),
                        contentDescription = null,
                        modifier = modifier
                            .size(70.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ProfileEditPreview() {
    PekaTheme {
        ProfileEditScreen(navController = rememberNavController())
    }
}