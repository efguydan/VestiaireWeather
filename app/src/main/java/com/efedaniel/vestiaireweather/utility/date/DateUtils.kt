package com.efedaniel.vestiaireweather.utility.date

import java.text.SimpleDateFormat
import java.util.*

fun Long.convertToDateString(): String {
    val date = Date(this)
    val dateFormat = SimpleDateFormat("dd.MM")
    return dateFormat.format(date)
}