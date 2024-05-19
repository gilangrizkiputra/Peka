package com.sukasrana.peka.utils

import com.sukasrana.peka.navigation.Screen

fun String?.shouldShowBottomBar(): Boolean{
    return this in setOf(
        Screen.Home.route
    )
}