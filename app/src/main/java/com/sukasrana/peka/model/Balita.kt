package com.sukasrana.peka.model

data class Balita(
    val id_balita: Int,
    val id_user: Int,
    val nama: String,
    val nik: Long,
    val gender: String,
    val birth_date: String,
    val birth_location: String,
    val blood_type: String
)