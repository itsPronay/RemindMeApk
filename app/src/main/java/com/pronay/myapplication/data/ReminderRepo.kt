package com.pronay.myapplication.data

import kotlinx.coroutines.flow.Flow


class ReminderRepo(private val reminderDao: ReminderDao) {
    suspend fun insert(reminder: Reminder){
        reminderDao.insertNewReminder(reminder)
    }
    suspend fun update(reminder: Reminder){
        reminderDao.updateNewReminder(reminder)
    }
    suspend fun delete(reminder: Reminder){
        reminderDao.deleteReminder(reminder)
    }
    fun getAllReminder() : Flow<List<Reminder>> = reminderDao.getAllRemainders()

}