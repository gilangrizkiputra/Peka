package com.sukasrana.peka.presentation.PendaftaranOnline

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.R
import com.sukasrana.peka.navigation.Screen
import com.sukasrana.peka.presentation.addFormChild.component.TextFieldCustom
import com.sukasrana.peka.ui.theme.PekaTheme

@Composable
fun PendaftaranOnlineScreen(
    navController: NavController,
    modifier: Modifier = Modifier

) {
    var nama by remember {
        mutableStateOf("")
    }
    var namaAnak by remember {
        mutableStateOf("")
    }

    var nikAnak by remember {
        mutableStateOf("")
    }

    var jam by remember {
        mutableStateOf("")
    }
    AddFormChildContent(
        navController = navController,
        nama = nama,
        namaAnak = namaAnak,
        nikAnak = nikAnak,
        jam = jam,
        onNamaChange = {nama = it},
        onNamaAnakChange = {namaAnak = it},
        onNikAnakChange = {nikAnak = it},
        onJamChange = {jam = it},
        onDaftarClick = {
            navController.navigate(Screen.CekNoAntrian.route)
        }
    )
}

@Composable
fun  AddFormChildContent(
    nama: String,
    namaAnak: String,
    nikAnak: String,
    jam: String,
    onNamaChange: (String) -> Unit,
    onNamaAnakChange: (String) -> Unit,
    onNikAnakChange: (String) -> Unit,
    onJamChange: (String) -> Unit,
    onDaftarClick: () -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
) {
    Column {
        IconButton(
            onClick = { navController.navigateUp() },
            modifier = modifier
                .padding(7.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                modifier = modifier
                    .size(30.dp)
            )
        }
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            Text(
                text = "Pendaftaran Online",
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp))
            Text(
                text = "Isi data diri Bunda",
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp
            )
            Spacer(modifier = Modifier.padding(32.dp))
            Text(
                text = "Nama Lengkap Bunda",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextFieldCustom(
                value = nama,
                onValueChange = onNamaChange,
            )
            Text(
                text = "Nama Anak",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextFieldCustom(
                value = namaAnak,
                onValueChange = onNamaAnakChange,
            )
            Text(
                text = "NIK Anak",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextFieldCustom(
                value = nikAnak,
                onValueChange = onNikAnakChange,
            )
            Text(
                text = "Jam",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextFieldCustom(
                value = jam,
                onValueChange = onJamChange,
                trailingIcon = {
                    Icon(painterResource(id = R.drawable.ic_tanggal), contentDescription = "")
                }
            )
            Button(
                onClick = onDaftarClick,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp)
                    .height(48.dp)
                    .clickable {

                    }
            ) {
                Text(
                    text = "Daftar",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PendaftaranOnlinePrev() {
    PekaTheme {
        PendaftaranOnlineScreen(navController = rememberNavController())
    }
}