package com.sukasrana.peka.presentation.home.component

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun AgeCalculator(dob: String): Int {
    // Define the date format
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    // Parse the date of birth
    val birthDate = LocalDate.parse(dob, formatter)
    // Get the current date
    val currentDate = LocalDate.now()
    // Calculate the age
    return Period.between(birthDate, currentDate).years
}
