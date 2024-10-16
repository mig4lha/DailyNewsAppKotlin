package com.mig.dailynewsapp.ui.theme

import java.net.URLEncoder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun String.parseDate() : Date? {
    //2024-10-14T08:20:01Z
    val pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    return SimpleDateFormat(pattern, Locale.getDefault())
        .parse(this)
}

fun String.encodeURL() : String {
    return URLEncoder.encode(this, "UTF-8")
}

fun Date.toYYYYMMDD() : String {
    val pattern = "yyyy-MM-dd"
    return SimpleDateFormat(pattern, Locale.getDefault())
        .format(this)
}

fun formatDate(dateString: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'",
        java.util.Locale.US)
    inputFormat.timeZone = TimeZone.getTimeZone("UTC")
    val outputFormat = SimpleDateFormat("EEEE, MMMM dd, yyyy 'at' hh:mm a",
        java.util.Locale.US)
    outputFormat.timeZone = TimeZone.getDefault()

    val date = inputFormat.parse(dateString)
    return outputFormat.format(date!!)
}