package com.sukasrana.peka.model

import com.airbnb.lottie.animation.content.Content


data class Article(
    val id_artikel: Int,
    val title: String,
    val image: String,
    val content: String,
    val date: String,
    val sumber: String,
)
