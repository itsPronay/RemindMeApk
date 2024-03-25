package com.pronay.myapplication.functions.date

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalTime

fun fromLocalTime(localTime: LocalTime): String {
    return localTime.toString()
}

@RequiresApi(Build.VERSION_CODES.O)
fun toLocalTime(value: String): LocalTime {
    return LocalTime.parse(value)
}