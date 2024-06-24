package com.sukasrana.peka.model

data class Balita(
    var id_balita: Int?,
    var id_user: Int,
    var nama: String,
    var nik: Long,
    var gender: String,
    var birth_date: String,
    var birth_location:String,
    var blood_type: String
)