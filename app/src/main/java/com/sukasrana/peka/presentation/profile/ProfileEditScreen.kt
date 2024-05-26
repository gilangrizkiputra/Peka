package com.sukasrana.peka.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.R
import com.sukasrana.peka.presentation.addFormChild.component.TextFieldCustom
import com.sukasrana.peka.ui.theme.PekaTheme

@Composable
fun ProfileEditScreen(
    navController: NavController,
    modifier: Modifier = Modifier
){

    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var provinsi by remember {
        mutableStateOf("")
    }
    var kabupaten by remember {
        mutableStateOf("")
    }
    var kecamatan by remember {
        mutableStateOf("")
    }
    var adress by remember {
        mutableStateOf("")
    }

    ProfileEditContent(
        name = name,
        email = email,
        provinsi = provinsi,
        kabupaten = kabupaten,
        kecamatan = kecamatan,
        adress = adress,
        onNameChange = {name = it},
        onEmailChange = {email = it},
        onProvChange = {provinsi = it},
        onKabChange = {kabupaten = it},
        onKecChange = {kecamatan = it},
        onAdressChange = {adress = it}
    )
}

@Composable
fun ProfileEditContent(
    name: String,
    email: String,
    provinsi: String,
    kabupaten: String,
    kecamatan: String,
    adress: String,
    onNameChange: (String) -> Unit,
    onProvChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onKabChange: (String) -> Unit,
    onKecChange: (String) -> Unit,
    onAdressChange: (String) -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
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
                    .padding(end = 10.dp))
            Text(
                text = "Ungah Foto Anda",
                style = MaterialTheme.typography.titleLarge)
        }
        Text(text = "Nama")
        TextFieldCustom(
            value = name,
            onValueChange = onNameChange)
        Text(text = "Email")
        TextFieldCustom(
            value = email,
            onValueChange = onEmailChange)
        Text(text = "Provinsi")
        TextFieldCustom(
            value = provinsi,
            onValueChange = onProvChange)
        Text(text = "Kabupaten/Kota")
        TextFieldCustom(
            value = kabupaten,
            onValueChange = onKabChange)
        Text(text = "Kecamatan")
        TextFieldCustom(
            value = kecamatan,
            onValueChange = onKecChange)
        Text(text = "Alamat")
        TextFieldCustom(
            value = adress,
            onValueChange = onAdressChange)
        Button(
            onClick = {},
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

@Preview
@Composable
private fun ProfileEditPreview(){
    PekaTheme {
        ProfileEditScreen(navController = rememberNavController())
    }
}