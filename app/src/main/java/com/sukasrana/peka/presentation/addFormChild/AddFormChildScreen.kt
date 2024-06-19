package com.sukasrana.peka.presentation.addFormChild

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.R
import com.sukasrana.peka.navigation.Screen
import com.sukasrana.peka.presentation.addFormChild.component.TextFieldCustom
import com.sukasrana.peka.ui.theme.PekaTheme
import com.sukasrana.peka.model.Balita
import com.sukasrana.peka.network.RetrofitInstance
import kotlinx.coroutines.launch
import java.io.IOException
import retrofit2.HttpException
import java.util.UUID

@Composable
fun AddFormChildScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var nomorKartuKeluarga by remember { mutableStateOf("") }
    var nikAnak by remember { mutableStateOf("") }
    var namaAnak by remember { mutableStateOf("") }
    var tempatLahir by remember { mutableStateOf("") }
    var tanggal by remember { mutableStateOf("") }
    var golonganDarah by remember { mutableStateOf("") }
    var selectedJenisKelamin by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()

    fun onSimpanClick() {

        // Validate nomorKartuKeluarga and nikAnak
        if (nomorKartuKeluarga.isBlank() || nikAnak.isBlank() || !nomorKartuKeluarga.isDigitsOnly() || !nikAnak.isDigitsOnly()) {
            Toast.makeText(context, "Nomor Kartu Keluarga dan NIK Anak harus berupa angka", Toast.LENGTH_LONG).show()
            return
        }

        val umur = calculateAge(tanggal)
        val balita = Balita(
            id_balita = 11, // Asumsikan ini akan diisi oleh database
            id_user = 1, // Ganti dengan ID pengguna yang sebenarnya
            nama = namaAnak,
            nik = nikAnak.toLong(),
            gender = selectedJenisKelamin ?: "",
            birth_date = tanggal,
            birth_location = tempatLahir,
            blood_type = golonganDarah
        )

        Log.d("BalitaData", "Data yang dikirim: $balita")

        scope.launch {
            try {
                val response = RetrofitInstance.api.addBalita(balita)
                if (response.isSuccessful) {
                    Log.d("BalitaData", "Data berhasil dikirim")
                    Toast.makeText(context, "Data anak berhasil ditambahkan", Toast.LENGTH_LONG).show()
                    navController.navigate(Screen.Home.route)
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.d("BalitaData", "Server Error: $errorBody")
                    Toast.makeText(context, "Server Error: $errorBody", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                when (e) {
                    is IOException -> {
                        Log.d("BalitaData", "Network Error: ${e.message}")
                        Toast.makeText(context, "Network Error: ${e.message}", Toast.LENGTH_LONG).show()
                    }
                    is HttpException -> {
                        val code = e.code()
                        val errorResponse = e.response()?.errorBody()?.string()
                        Log.d("BalitaData", "HTTP Error: Code $code, $errorResponse")
                        Toast.makeText(context, "HTTP Error: Code $code", Toast.LENGTH_LONG).show()
                    }
                    else -> {
                        Log.d("BalitaData", "Unknown Error: ${e.message}")
                        Toast.makeText(context, "Unknown Error: ${e.message}", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    AddFormChildContent(
        navController = navController,
        nomorKartuKeluarga = nomorKartuKeluarga,
        nikAnak = nikAnak,
        namaAnak = namaAnak,
        tempatLahir = tempatLahir,
        tanggal = tanggal,
        golonganDarah = golonganDarah,
        onNomorKartuKeluargaChange = { nomorKartuKeluarga = it },
        onnikAnakChange = { nikAnak = it },
        onnamaAnakChange = { namaAnak = it },
        ontempatLahirChange = { tempatLahir = it },
        ontanggalChange = { tanggal = it },
        ongolonganDarahChange = { golonganDarah = it },
        selectedJenisKelamin = selectedJenisKelamin,
        onJenisKelaminChange = { selectedJenisKelamin = it },
        onSimpanClick = { onSimpanClick() }
    )
}

@Composable
fun AddFormChildContent(
    nomorKartuKeluarga: String,
    nikAnak: String,
    namaAnak: String,
    tempatLahir: String,
    tanggal: String,
    golonganDarah: String,
    onNomorKartuKeluargaChange: (String) -> Unit,
    onnikAnakChange: (String) -> Unit,
    onnamaAnakChange: (String) -> Unit,
    ontempatLahirChange: (String) -> Unit,
    ontanggalChange: (String) -> Unit,
    ongolonganDarahChange: (String) -> Unit,
    selectedJenisKelamin: String?,
    onJenisKelaminChange: (String) -> Unit,
    onSimpanClick: () -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
) {
    Column {
        IconButton(
            onClick = { navController.navigateUp() },
            modifier = modifier.padding(7.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                modifier = modifier.size(30.dp)
            )
        }
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            Text(
                text = "Tambah Identitas Anak",
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
            )
            Text(
                text = "Nomor Kartu Keluarga",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextFieldCustom(
                value = nomorKartuKeluarga,
                onValueChange = onNomorKartuKeluargaChange,
            )
            Text(
                text = "NIK Anak",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextFieldCustom(
                value = nikAnak,
                onValueChange = onnikAnakChange,
            )
            Text(
                text = "Nama Anak",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextFieldCustom(
                value = namaAnak,
                onValueChange = onnamaAnakChange,
            )
            Row {
                Column {
                    Text(
                        text = "Tempat Lahir",
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    TextFieldCustom(
                        value = tempatLahir,
                        onValueChange = ontempatLahirChange,
                        modifier = Modifier.width(215.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(end = 16.dp))
                Column {
                    Row {
                        Text(
                            text = "Tanggal",
                            modifier = Modifier.padding(bottom = 8.dp, end = 8.dp)
                        )
                        Icon(
                            painterResource(id = R.drawable.ic_tanggal),
                            contentDescription = "tanggal"
                        )
                    }
                    TextFieldCustom(
                        value = tanggal,
                        onValueChange = ontanggalChange,
                        modifier = Modifier.width(130.dp)
                    )
                }
            }
            Text(
                text = "Golongan Darah",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextFieldCustom(
                value = golonganDarah,
                onValueChange = ongolonganDarahChange,
            )
            Text(
                text = "Jenis Kelamin",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            RadioButton(
                selectedOption = selectedJenisKelamin,
                onOptionSelected = onJenisKelaminChange
            )
            Button(
                onClick = onSimpanClick,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp)
                    .height(48.dp)
            ) {
                Text(
                    text = "Simpan",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun RadioButton(
    selectedOption: String?,
    onOptionSelected: (String) -> Unit
) {
    val radioOptions = listOf("Laki - Laki", "Perempuan")
    Row {
        radioOptions.forEach { text ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) }
                    )
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AddFormChildPrev() {
    PekaTheme {
        AddFormChildScreen(navController = rememberNavController())
    }
}

