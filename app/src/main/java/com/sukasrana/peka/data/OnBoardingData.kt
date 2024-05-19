package com.sukasrana.peka.data

import android.annotation.SuppressLint
import com.sukasrana.peka.R
import com.sukasrana.peka.model.OnBoardingItem

object OnBoardingData {
    @SuppressLint("ResourceType")
    val onBoardingItems = listOf(
        OnBoardingItem(
            resId = R.drawable.onboarding1,
            title = "Pantau dan Catat Perkembangan Buah Hati",
            description = "Pantau dan Catat Perkembangan Buah Hati Bunda mulai dari berat badan, tinggi badan, dan tingkah laku mereka."
        ),
        OnBoardingItem(
            resId = R.drawable.onboarding2,
            title = "Pilih Makanan Bergizi yang kaya akan nutrisi untuk Buah Hati ",
            description = "Menu Makanan yang sesuai dengan kebutuhan gizi  buah hati, Bunda bisa membuatnya  sendiri di rumah."
        ),
        OnBoardingItem(
            resId = R.drawable.onboarding3,
            title = "Cek Informasi seputar posyandu",
            description = "Bunda akan mendapatkan Informasi seputas kegiatan posyandu, jadi tidak perlu takut ketinggal informasi."
        ),
    )
}