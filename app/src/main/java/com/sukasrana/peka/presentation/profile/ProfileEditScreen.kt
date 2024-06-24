@file:OptIn(ExperimentalMaterial3Api::class)

package com.sukasrana.peka.presentation.profile

import android.graphics.Bitmap
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
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
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.sukasrana.peka.R
import com.sukasrana.peka.data.repository.fetchUserById
import com.sukasrana.peka.data.repository.updateUser
import com.sukasrana.peka.model.User
import com.sukasrana.peka.presentation.addFormChild.component.TextFieldCustom
import com.sukasrana.peka.presentation.component.NumberTextField
import com.sukasrana.peka.presentation.component.PasswordTextField
import com.sukasrana.peka.ui.theme.PekaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileEditScreen(
    navController: NavController,
    userId: Int
) {
    val context = LocalContext.current

    var user by remember {
        mutableStateOf<User?>(null)
    }

    var updateUserById by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(userId) {
        user = fetchUserById(userId)
    }

    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
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

    var profileImage by remember {
        mutableStateOf<Any?>(null)
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview(),
        onResult = { bitmap ->
            profileImage = bitmap
        }
    )

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            profileImage = uri
        }
    )

    LaunchedEffect(user) {
        user?.let {
            name = it.nama
            email = it.email
            nkk = it.nik.toString()
            profileImage = it.foto_profile
        }
    }

    isEnable = password == pass


    LaunchedEffect(updateUserById) {
        if (updateUserById) {
            val updatedUser = User(
                id_user = userId,
                nama = name,
                email = email,
                password = password,
                nik = nkk.toLong(),
                alamat = nkk,
                authority = user?.authority ?: "",
                foto_profile = profileImage.toString()
            )
            val success = updateUser(userId, updatedUser)
            if (success) {
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
                navController.navigateUp()
            } else {
                Toast.makeText(context, "Update failed", Toast.LENGTH_SHORT).show()
            }
            updateUserById = false
        }
    }

    ProfileEditContent(
        isEnable = isEnable,
        navController = navController,
        name = name,
        email = email,
        nkk = nkk,
        password = password,
        pass = pass,
        onNameChange = { name = it },
        onEmailChange = { email = it },
        onNkkChange = { nkk = it },
        onPasswordChange = { password = it },
        onPassChange = { pass = it },
        onCameraClick = {
            cameraLauncher.launch()
        },
        onGalleryClick = {
            galleryLauncher.launch("image/*")
        },
        profileImage = profileImage,
        onSubmit = {
            updateUserById = true
        }
    )
}

@Composable
fun ProfileEditContent(
    isEnable: Boolean,
    name: String,
    email: String,
    nkk: String,
    password: String,
    pass: String,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onNkkChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPassChange: (String) -> Unit,
    onCameraClick: () -> Unit,
    onGalleryClick: () -> Unit,
    profileImage: Any?,
    onSubmit: () -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val sheetState = rememberModalBottomSheetState()
    val isSheetOpen = rememberSaveable {
        mutableStateOf(false)
    }

    val context = LocalContext.current

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
                if (profileImage is Bitmap){
                    Image(
                        bitmap = (profileImage as Bitmap).asImageBitmap(),
                        contentDescription = "Profile",
                        modifier = modifier
                            .padding(end = 10.dp)
                            .size(76.dp)
                            .clip(CircleShape)
                            .clickable { isSheetOpen.value = true }
                    )
                }else if (profileImage is Uri){
                    Image(
                        painter = rememberImagePainter(profileImage as Uri),
                        contentDescription = "Profile",
                        modifier = modifier
                            .padding(end = 10.dp)
                            .clip(CircleShape)
                            .size(76.dp)
                            .clickable { isSheetOpen.value = true }
                    )
                }else{
                    Image(
                        painter = painterResource(id = R.drawable.image_profile),
                        contentDescription = "Profile",
                        modifier = modifier
                            .padding(end = 10.dp)
                            .clickable { isSheetOpen.value = true }
                    )
                }
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
            Text(text = "Nomor Kartu Keluarga")
            NumberTextField(
                value = nkk,
                onValueChange = onNkkChange
            )
            Text(text = "Kata Sandi")
            PasswordTextField(
                text = password,
                onValueChange = onPasswordChange,
                label = "Kata sandi"
            )
            Spacer(modifier = modifier.padding(top = 8.dp))
            Text(text = "Masukan Ulang Kata Sandi")
            PasswordTextField(
                text = pass,
                onValueChange = onPassChange,
                label = "Konfirmasi Kata Sandi"
            )

            Button(
                onClick = { onSubmit() },
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
                            .clickable {
                                Toast
                                    .makeText(context, "Fitur Belum Tersedia", Toast.LENGTH_LONG)
                                    .show()
                            }
                    )
                    Spacer(modifier = modifier.padding(5.dp))
                    Image(
                        painter = painterResource(id = R.drawable.icon_gallery),
                        contentDescription = null,
                        modifier = modifier
                            .size(70.dp)
                            .clickable { onGalleryClick() }
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//private fun ProfileEditPreview() {
//    PekaTheme {
//        ProfileEditScreen(navController = rememberNavController())
//    }
//}