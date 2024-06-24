package com.sukasrana.peka.model

data class User(
    val id_user: Int?,
    val nama: String,
    val email: String,
    val password: String,
    val nik: Long,
    val alamat: String,
    val authority: String,
    val foto_profile: String

)
