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
import androidx.compose.runtime.derivedStateOf
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
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.R
import com.sukasrana.peka.model.Balita
import com.sukasrana.peka.model.User
import com.sukasrana.peka.navigation.Screen
import com.sukasrana.peka.network.RetrofitInstance
import com.sukasrana.peka.presentation.addFormChild.component.TextFieldCustom
import com.sukasrana.peka.ui.theme.PekaTheme
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.MaterialDialogState
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun AddFormChildScreen(
    navController: NavController,
    modifier: Modifier = Modifier

) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val radioOptions = listOf("man", "woman")
    var (selectedOption, onOptionSelected) = remember { mutableStateOf("") }
    var picekdDate by remember {
        mutableStateOf(LocalDate.now())
    }
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("yyyy-MM-dd")
                .format(picekdDate)
        }
    }

    var namaAnak by remember {
        mutableStateOf("")
    }

    var nikAnak by remember {
        mutableStateOf("")
    }

    var gender by remember {
        mutableStateOf("")
    }

    var birth_date by remember {
        mutableStateOf("")
    }

    var tempatLahir by remember {
        mutableStateOf("")
    }

    var golonganDarah by remember {
        mutableStateOf("")
    }

    fun onAddBalitaClick() {
        if (namaAnak.isEmpty() || nikAnak.isEmpty() || selectedOption.isEmpty() || tempatLahir.isEmpty() || golonganDarah.isEmpty()) {
            Toast.makeText(context, "Data belum lengkap", Toast.LENGTH_LONG).show()
            return
        }
        gender = selectedOption
        birth_date = formattedDate
        val balita = Balita(
            id_balita = null,
            id_user = 1,
            nama = namaAnak,
            nik = nikAnak.toLong(),
            gender = gender,
            birth_date = birth_date,
            birth_location = tempatLahir,
            blood_type = golonganDarah
        )
        Log.d("BalitaData", "Data yang dikirim: $balita")

        coroutineScope.launch {
            try {
                val response = RetrofitInstance.api.addBalita(balita)
                if (response.isSuccessful) {
                    Log.d("BalitaData", "Daftar berhasil")
                    Toast.makeText(context, "Daftar Berhasil", Toast.LENGTH_LONG).show()
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
                        Toast.makeText(context, "Network Error: ${e.message}", Toast.LENGTH_LONG)
                            .show()
                    }

                    is HttpException -> {
                        val code = e.code()
                        val errorResponse = e.response()?.errorBody()?.string()
                        Log.d("BalitaData", "HTTP Error: Code $code, $errorResponse")
                        Toast.makeText(context, "HTTP Error: Code $code", Toast.LENGTH_LONG).show()
                    }

                    else -> {
                        Log.d("BalitaData", "Unknown Error: ${e.message}")
                        Toast.makeText(context, "Unknown Error: ${e.message}", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }
    val dateDialogState = rememberMaterialDialogState()
    MaterialDialog(
        dialogState = dateDialogState,
        properties = DialogProperties(
            dismissOnBackPress = true
        ),
        buttons = {
            positiveButton(text = "Ok")
            negativeButton(text = "Batal")
        }
    ) {
        datepicker(
            initialDate = LocalDate.now(),
            title = "Pilih Tanggal"
        ){
            picekdDate = it
        }
    }

    AddFormChildContent(
        radioOptions = radioOptions,
        selectedOption = selectedOption,
        onOptionSelected = onOptionSelected,
        dateDialogState = dateDialogState,
        formattedDate = formattedDate,
        navController = navController,
        namaAnak = namaAnak,
        nikAnak = nikAnak,
        tempatLahir = tempatLahir,
        golonganDarah = golonganDarah,
        onnamaAnakChange = { namaAnak = it },
        onnikAnakChange = { nikAnak = it },
        ontempatLahirChange = { tempatLahir = it },
        ongolonganDarahChange = { golonganDarah = it },
        onSimpanClick = { onAddBalitaClick() }
    )
}

@Composable
fun AddFormChildContent(
    namaAnak: String,
    nikAnak: String,
    tempatLahir: String,
    golonganDarah: String,
    radioOptions: List<String>,
    selectedOption: String,
    onOptionSelected: (selectedOption: String) -> Unit,
    dateDialogState: MaterialDialogState,
    formattedDate: String,
    onnamaAnakChange: (String) -> Unit,
    onnikAnakChange: (String) -> Unit,
    ontempatLahirChange: (String) -> Unit,
    ongolonganDarahChange: (String) -> Unit,
    onSimpanClick: () -> Unit,
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
                text = "Tambah Identitas Anak",
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
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
                Column(
                ) {
                    Text(
                        text = "Tempat Lahir",
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    TextFieldCustom(
                        value = tempatLahir,
                        onValueChange = ontempatLahirChange,
                        modifier = Modifier
                            .width(215.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(end = 16.dp))
                Column(
                ) {
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
                    //TextFieldCustom(
                    //    value = tanggal,
                    //    onValueChange = ontanggalChange,
                    //    modifier = Modifier
                    //        .width(130.dp)
                    //        .clickable {
                    //            dateDialogState.show()
                    //        }
                    //)
                    Button(
                        onClick = { dateDialogState.show() },
                        modifier = modifier
                            .height(55.dp)
                    ) {
                        Text(text = formattedDate)
                    }
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
            RButton(radioOptions = radioOptions, selectedOption = selectedOption,onOptionSelected)

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
fun RButton(
    radioOptions: List<String>,
    selectedOption: String,
    onOptionSelected: (selectedOption: String) -> Unit,
) {
    Row(
    ) {
        radioOptions.forEach { text ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
            ) {
                RadioButton(
                    selected = selectedOption == text,
                    onClick = {
                        onOptionSelected(text)
                    }
                )
                Text(
                    text = when{
                        text == "man" -> "Laki - Laki"
                        else -> "Perempuan"
                    } ,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
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

