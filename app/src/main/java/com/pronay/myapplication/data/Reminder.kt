package com.pronay.myapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime

@Entity ( tableName = "reminderDB")
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var title: String,
    var details: String = "N/A",
    var time: String ?= null,
    var date: Long,
    var stared: Boolean = false,
    var deleted: Boolean = false,
)