package com.pronay.myapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Reminder::class],
    version = 1
    )
abstract class ReminderDataBase: RoomDatabase(){
    abstract fun reminderDao() : ReminderDao
}
