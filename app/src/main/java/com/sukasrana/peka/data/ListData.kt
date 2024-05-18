package com.sukasrana.peka.data

import com.sukasrana.peka.R
import com.sukasrana.peka.model.Balita
import com.sukasrana.peka.model.Mpasi

object ListData {
    val dataBalita = listOf(
        Balita(
            id = 1,
            nomorKartuKeluarga = 321001001001,
            nikAnak = 3211505240016,
            nama = "Asep Knalpot",
            tempatLahir = "Madiun",
            tanggal = "15-05-24",
            umur = 2,
            golanganDarah = "A",
            jenisKelamin = "Laki-laki"
        ),
    )

    val mpasi = listOf(
        Mpasi(
            id = 1,
            nama = "Bubur Brokoli dan Wortel",
            desk = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione rerum labore dolorem cumque, fugit ab nostrum eveniet veniam placeat quidem similique omnis nemo fuga alias assumenda. Odit, non ut! Error!",
            tanggal = "15 Mei 2024",
            photo = R.drawable.image_bubur_brokoli_mpasi_beranda
        ),
        Mpasi(
            id = 2,
            nama = "Bubur pisang dan Jeruk",
            desk = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione rerum labore dolorem cumque, fugit ab nostrum eveniet veniam placeat quidem similique omnis nemo fuga alias assumenda. Odit, non ut! Error!",
            tanggal = "15 Mei 2024",
            photo = R.drawable.image_bubur_pisang_jeruk_mpasi_beranda2
        )
    )
}