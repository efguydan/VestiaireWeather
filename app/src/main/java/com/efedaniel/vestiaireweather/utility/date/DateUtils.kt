package com.efedaniel.vestiaireweather.utility.date

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

const val SHORT_DATE_FORMAT = "dd.MM"
const val LONG_DATE_FORMAT = "dd MMMM, yyyy"

/**
 * Helper method to convert time from Epoch format to a specified format
 */
fun Long.convertToDateString(format: String): String {
    val date = Date(this)
    val dateFormat = SimpleDateFormat(format)
    return dateFormat.format(date)
}

/**
 * Helper method to time from Epoch format to a day of the week
 */
fun Long.getDayOfWeek(): String {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = Date(this).time
    return when (calendar.get(Calendar.DAY_OF_WEEK)) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> ""
    }
}
