package com.pronay.myapplication.functions

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import java.time.LocalTime

/*
returns time in 12 hours of format
 */
@OptIn(ExperimentalMaterial3Api::class)

fun timePickerStateToString(timePickerState: TimePickerState): String {
    val hour = if (timePickerState.hour == 0) 12 else if (timePickerState.hour > 12) timePickerState.hour - 12 else timePickerState.hour
    val minuteStr = if (timePickerState.minute < 10) "0${timePickerState.minute}" else "${timePickerState.minute}"
    val period = if (timePickerState.hour >= 12) "PM" else "AM"
    return "$hour:$minuteStr $period"
}

/*
returns time in 24h format
 */
@OptIn(ExperimentalMaterial3Api::class)
fun timePickerStateToString24(timePickerState: TimePickerState): String {
    return String.format("%02d:%02d", timePickerState.hour, timePickerState.minute)
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
fun timePickerStateToLocalTime(timePickerState: TimePickerState): LocalTime {
    return LocalTime.of(timePickerState.hour, timePickerState.minute) //24h
}
/*
converts 24h TimePickerState to 12hour string
 */
@OptIn(ExperimentalMaterial3Api::class)
fun timePickerStateTo12HourString(timePickerState: TimePickerState): String {
    val hour = if (timePickerState.hour == 0 || timePickerState.hour == 12) {
        12
    } else {
        timePickerState.hour % 12
    }
    val period = if (timePickerState.hour < 12) "AM" else "PM"
    return String.format("%02d:%02d %s", hour, timePickerState.minute, period)
}
