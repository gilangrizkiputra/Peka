package com.sukasrana.peka.presentation.addFormChild

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun calculateAge(tanggal: String): Int {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val birthDate: LocalDate
    try {
        birthDate = LocalDate.parse(tanggal, formatter)
    } catch (e: DateTimeParseException) {
        throw IllegalArgumentException("Tanggal lahir '$tanggal' tidak valid. Harap gunakan format 'yyyy-MM-dd'.")
    }

    val currentDate = LocalDate.now()
    return Period.between(birthDate, currentDate).years
}