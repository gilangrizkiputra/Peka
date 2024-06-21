package com.sukasrana.peka.presentation.home.component

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException


fun convertDateFormat(originalDate: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    val dateTime = LocalDateTime.parse(originalDate, formatter)
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return dateTime.format(dateFormatter)
}

fun AgeCalculator(dob: String): Pair<Int, Int> {
    return try {
        val formattedDate = convertDateFormat(dob)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val localDate = LocalDate.parse(formattedDate, formatter)

        val currentDate = LocalDate.now()

        val period = Period.between(localDate, currentDate)
        val years = period.years
        val months = period.months

        Pair(years, months)
    } catch (e: DateTimeParseException) {
        e.printStackTrace()
        Pair(-1, -1)
    }
}

//fun main() {
//    val birthDateFromDatabase = "2023-04-08T17:00:00.000Z"
//    println("Nilai birth_date dari database: $birthDateFromDatabase")
//
//    val (years, months) = AgeCalculator(birthDateFromDatabase)
//
//    if (years != -1 && months != -1) {
//        if (years < 1) {
//            println("Umur: $months bulan")
//        } else {
//            println("Umur: $years tahun $months bulan")
//        }
//    } else {
//        println("Format tanggal tidak valid atau terjadi kesalahan.")
//    }
//}