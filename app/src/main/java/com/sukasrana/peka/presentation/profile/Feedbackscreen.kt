package com.sukasrana.peka.presentation.profile

import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sukasrana.peka.presentation.component.MassageTextField
import com.sukasrana.peka.presentation.addFormChild.component.TextFieldCustom
import com.sukasrana.peka.presentation.component.NumberTextField
import com.sukasrana.peka.ui.theme.PekaTheme

@Composable
fun FeedbackScreen(
    navController: NavController,
    modifier: Modifier = Modifier
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
    var massage by remember {
        mutableStateOf("")
    }
    FeedbackContent(
        name = name,
        number = number,
        email = email,
        massage = massage,
        onNameChange = { name = it },
        onNumberChange = { number = it },
        onEmailChange = { email = it },
        onMassageChange = { massage = it }
    )
}

@Composable
private fun FeedbackContent(
    name: String,
    number: String,
    email: String,
    massage: String,
    onNameChange: (String) -> Unit,
    onNumberChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onMassageChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Bantuan & Laporan",
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier.padding(bottom = 20.dp))
        Text(text = "Nama")
        TextFieldCustom(value = name, onValueChange = onNameChange)
        Text(text = "Nomor")
        NumberTextField(value = number, onValueChange = onNumberChange)
        Text(text = "Email")
        TextFieldCustom(value = email, onValueChange = onEmailChange)
        Text(text = "Catatan")
        MassageTextField(value = massage, onValueChange = onMassageChange)
        Button(
            onClick = {},
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(top = 20.dp)
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

@Preview(showBackground = true)
@Composable
private fun FeedbackScreenPreview() {
    PekaTheme {
        FeedbackScreen(navController = rememberNavController())
    }
}