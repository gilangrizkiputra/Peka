package com.sukasrana.peka.data

import co.yml.charts.common.model.Point
import com.sukasrana.peka.R
import com.sukasrana.peka.model.Balita
import com.sukasrana.peka.model.Mpasi
import com.sukasrana.peka.model.Article
import com.sukasrana.peka.model.Mkia
import com.sukasrana.peka.model.MpasiModel


object ListData {
    val dataBalita = listOf(
        Balita(
            id_balita = 1,
            id_user = 1,
            nik = 321001001001,
            nama = "Asep Knalpot",
            gender = "Laki - Laki",
            birth_date = "15-05-24",
            blood_type = "A",
            birth_location = "Madiun"
        ),
    )

//    val mpasi = listOf(
//        Mpasi(
//            id = 1,
//            nama = "Bubur Brokoli dan Wortel",
//            desk = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione rerum labore dolorem cumque, fugit ab nostrum eveniet veniam placeat quidem similique omnis nemo fuga alias assumenda. Odit, non ut! Error!",
//            tanggal = "15 Mei 2024",
//            photo = R.drawable.image_bubur_brokoli_mpasi_beranda
//        ),
//        Mpasi(
//            id = 2,
//            nama = "Bubur pisang dan Jeruk",
//            desk = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ratione rerum labore dolorem cumque, fugit ab nostrum eveniet veniam placeat quidem similique omnis nemo fuga alias assumenda. Odit, non ut! Error!",
//            tanggal = "15 Mei 2024",
//            photo = R.drawable.image_bubur_pisang_jeruk_mpasi_beranda2
//        )
//    )

//    val TheArticel = listOf(
//        Article(
//            id = 1,
//            title = R.string.titleArticle1,
//            contentAr = R.string.contentArticle1,
//            date = "12 April 2024",
//            photo = R.drawable.nutrisi
//        ),
//        Article(
//            id = 2,
//            title = R.string.titleArticle2,
//            contentAr = R.string.contentArticle2,
//            date = "13 Januari 2024",
//            photo = R.drawable.polaasuh
//        ),
//        Article(
//            id = 3,
//            title = R.string.titleArticle3,
//            contentAr = R.string.contentArticle3,
//            date = "12 Januari 2024",
//            photo = R.drawable.anakmenelanasing
//        ),
//        Article(
//            id = 4,
//            title = R.string.titleArticle4,
//            contentAr = R.string.contentArtikel4,
//            date = "12 Januari 2024",
//            photo = R.drawable.anakpendiam
//        ),
//        Article(
//            id = 5,
//            title = R.string.titleArticle5,
//            contentAr = R.string.contentArticle5,
//            date = "12 Januari 2024",
//            photo = R.drawable.anakmenelanasing
//        ),
//        Article(
//            id = 6,
//            title = R.string.titleArticle2,
//            contentAr = R.string.contentArticle2,
//            date = "12 Januari 2024",
//            photo = R.drawable.polaasuh
//        ),
//    )

//    val TheMpasi = listOf(
//        MpasiModel(
//            id = 1,
//            desk = "Resep MPASI, 6 Bulan, Makan Pagi Makan Siang, Makan Malam",
//            nama = R.string.menu_buburWortel,
//            gizi = R.string.gizi_buburWortel,
//            bahan = R.string.bahan_buburWortel,
//            bulan = 6,
//            caramemasak = R.string.cara_buburWortel,
//            tanggal = "12 Januari",
//            photo = R.drawable.nutrisi,
//            logo = R.drawable.ic_mpasi
//        ),
//        MpasiModel(
//            id = 2,
//            desk = "Resep MPASI, 6 Bulan, Makan Pagi Makan Siang, Makan Malam",
//            nama = R.string.menu_appleStew,
//            gizi = R.string.gizi_appleStew,
//            bahan = R.string.bahan_appleStew,
//            bulan = 6,
//            caramemasak = R.string.cara_appleStew,
//            tanggal = "12 Januari",
//            photo = R.drawable.nutrisi,
//            logo = R.drawable.ic_mpasi
//        ),
//        MpasiModel(
//            id = 3,
//            desk = "Resep MPASI, 8 Bulan, Makan Pagi Makan Siang, Makan Malam",
//            nama = R.string.menu_buburTongseng,
//            gizi = R.string.gizi_buburTongseng,
//            bahan = R.string.bahan_buburTongseng,
//            bulan = 8,
//            caramemasak = R.string.cara_buburTongseng,
//            tanggal = "12 Januari",
//            photo = R.drawable.nutrisi,
//            logo = R.drawable.ic_mpasi
//        ),
//        MpasiModel(
//            id = 4,
//            desk = "Resep MPASI, 8 Bulan, Makan Pagi Makan Siang, Makan Malam",
//            nama = R.string.menu_oatmeal,
//            gizi = R.string.gizi_oatmeal,
//            bahan = R.string.bahan_oatmeal,
//            bulan = 8,
//            caramemasak = R.string.cara_oatmeal,
//            tanggal = "12 Januari",
//            photo = R.drawable.nutrisi,
//            logo = R.drawable.ic_mpasi
//        ),
//        MpasiModel(
//            id = 5,
//            desk = "Resep MPASI, 11 Bulan, Makan Pagi Makan Siang, Makan Malam",
//            nama = R.string.menu_nasiTim,
//            gizi = R.string.gizi_nasiTim,
//            bahan = R.string.bahan_nasiTim,
//            bulan = 11,
//            caramemasak = R.string.cara_nasiTim,
//            tanggal = "12 Januari",
//            photo = R.drawable.nutrisi,
//            logo = R.drawable.ic_mpasi
//        ),
//        MpasiModel(
//            id = 6,
//            desk = "Resep MPASI, 11 Bulan, Makan Pagi Makan Siang, Makan Malam",
//            nama = R.string.menu_berasMerah,
//            gizi = R.string.gizi_berasMerah,
//            bahan = R.string.bahan_berasMerah,
//            bulan = 11,
//            caramemasak = R.string.cara_berasMerah,
//            tanggal = "12 Januari",
//            photo = R.drawable.nutrisi,
//            logo = R.drawable.ic_mpasi
//        ),
//        MpasiModel(
//            id = 7,
//            desk = "Resep MPASI, 12 Bulan, Makan Pagi Makan Siang, Makan Malam",
//            nama = R.string.menu_buburKentang,
//            gizi = R.string.gizi_buburKentang,
//            bahan = R.string.bahan_buburKentang,
//            bulan = 12,
//            caramemasak = R.string.cara_buburKentang,
//            tanggal = "12 Januari",
//            photo = R.drawable.nutrisi,
//            logo = R.drawable.ic_mpasi
//        ),
//
//        )

//    val listMkia = listOf(
//        Mkia(
//            id = 1,
//            name = "Nutrisi pada Masa Laktasi",
//            category = 0,
//            description = "Selama masa laktasi (menyusui), penting bagi ibu untuk memperhatikan asupan nutrisinya agar dapat memberikan nutrisi yang cukup bagi bayi serta menjaga kesehatan dirinya sendiri. \n" +
//                    "Protein diperlukan untuk pertumbuhan dan perkembangan bayi\n" +
//                    "Karbohidrat merupakan sumber energi utama.\n" +
//                    "Lemak penting untuk produksi ASI yang baik.\n" +
//                    "Kalsium penting untuk kesehatan tulang dan gigi, baik untuk ibu maupun bayi.",
//            image = R.drawable.image_detail_nutrisimasalaktasi_ibu_mkia
//        ),
//        Mkia(
//            id = 2,
//            name = "Kehamilan Sehat",
//            category = 0,
//            description =
//            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque facilisis lorem arcu, eget faucibus eros tincidunt ut. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec eros sit amet sem semper suscipit. Donec ut nisl erat. Morbi finibus sem ac ligula bibendum, quis ultrices massa ornare. Cras at tempor odio. Proin neque massa, porta vel turpis vel, elementum porta eros. Aenean vitae ante arcu. Donec bibendum dolor quis finibus ullamcorper.",
//            image = R.drawable.image_kehamilansehat_mkia
//        ),
//        Mkia(
//            id = 3,
//            name = "Kesehatan Lingkungan",
//            category = 0,
//            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque facilisis lorem arcu, eget faucibus eros tincidunt ut. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec eros sit amet sem semper suscipit. Donec ut nisl erat. Morbi finibus sem ac ligula bibendum, quis ultrices massa ornare. Cras at tempor odio. Proin neque massa, porta vel turpis vel, elementum porta eros. Aenean vitae ante arcu. Donec bibendum dolor quis finibus ullamcorper.",
//            image = R.drawable.image_kesehatanlingkungan_mkia
//        ),
//        Mkia(
//            id = 4,
//            name = "Perawatan Anak Sakit",
//            category = 1,
//            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque facilisis lorem arcu, eget faucibus eros tincidunt ut. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec eros sit amet sem semper suscipit. Donec ut nisl erat. Morbi finibus sem ac ligula bibendum, quis ultrices massa ornare. Cras at tempor odio. Proin neque massa, porta vel turpis vel, elementum porta eros. Aenean vitae ante arcu. Donec bibendum dolor quis finibus ullamcorper.",
//            image = R.drawable.image_anak_rawatanaksakit_mkia
//        ),
//        Mkia(
//            id = 5,
//            name = "Warna Tinja dan Air Kencing",
//            category = 1,
//            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque facilisis lorem arcu, eget faucibus eros tincidunt ut. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec eros sit amet sem semper suscipit. Donec ut nisl erat. Morbi finibus sem ac ligula bibendum, quis ultrices massa ornare. Cras at tempor odio. Proin neque massa, porta vel turpis vel, elementum porta eros. Aenean vitae ante arcu. Donec bibendum dolor quis finibus ullamcorper.",
//            image = R.drawable.image_anak_warnatinjadanairkencing_mkia
//        ),
//        Mkia(
//            id = 6,
//            name = "Cek Kesahatan Balita",
//            category = 1,
//            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque facilisis lorem arcu, eget faucibus eros tincidunt ut. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec eros sit amet sem semper suscipit. Donec ut nisl erat. Morbi finibus sem ac ligula bibendum, quis ultrices massa ornare. Cras at tempor odio. Proin neque massa, porta vel turpis vel, elementum porta eros. Aenean vitae ante arcu. Donec bibendum dolor quis finibus ullamcorper.",
//            image = R.drawable.image_anak_nutrisipadamasalaktasi_mkia
//        )
//    )

    val DataBerat: List<Point> =
        listOf(
            Point(1f, 0f),
            Point(2f, 1f),
            Point(3f, 3f),
            Point(4f, 4f),
        )

    val DataTinggi: List<Point> =
        listOf(
            Point(0f, 0f),
            Point(1f, 8f),
            Point(2f, 12f),
            Point(3f, 16f),
            Point(4f, 20f)
        )
}