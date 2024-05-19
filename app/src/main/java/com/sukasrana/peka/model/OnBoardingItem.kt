package com.sukasrana.peka.model

import androidx.annotation.RawRes

data class OnBoardingItem(
    @RawRes
    val resId: Int,
    val title: String,
    val description: String
)
