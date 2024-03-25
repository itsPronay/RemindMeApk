package com.pronay.myapplication.data

import android.content.Context
import androidx.room.Room

object graph {
    lateinit var dataBase: ReminderDataBase
/*
we are passing reminderDao of database
into the repository
 */
    /* or
    pass dao from database into repository
     */
    val reminderRepo by lazy {
        ReminderRepo(dataBase.reminderDao())
    }
    fun provide(context: Context){
        dataBase = Room.databaseBuilder(context, ReminderDataBase::class.java, "reminderDB").build()
    }
}