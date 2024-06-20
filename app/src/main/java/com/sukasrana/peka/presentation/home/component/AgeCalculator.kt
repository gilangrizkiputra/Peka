package com.sukasrana.peka.presentation.home.component

import java.time.Instant
import java.time.LocalDate
import java.time.Period
import java.time.ZoneId

fun AgeCalculator(dob: String): Int {
    // Convert date format
    val instant = Instant.parse(dob)
    val localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate()
    // Get the current date
    val currentDate = LocalDate.now()
    // Calculate the age
    return Period.between(localDate, currentDate).months
}
