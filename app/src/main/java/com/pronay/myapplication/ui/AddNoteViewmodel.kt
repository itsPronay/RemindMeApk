package com.pronay.myapplication.ui

import androidx.compose.material3.DatePickerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pronay.myapplication.data.Reminder
import com.pronay.myapplication.data.ReminderRepo
import com.pronay.myapplication.data.graph
import com.pronay.myapplication.data.graph.reminderRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime

class AddNoteViewmodel(private val reminderRepoo: ReminderRepo = graph.reminderRepo): ViewModel() {
    var title by mutableStateOf("")
    var details by mutableStateOf("")
    var supportingText by mutableStateOf("")
    var titleError by mutableStateOf(false)

    var date : String by mutableStateOf("")
    var time : String by mutableStateOf("")

    fun updateTitle(title: String){
        this.title = title
    }
    fun updateDetails(details : String){
        this.details = details
    }
    fun updateSupportingText(text : String){
        supportingText = text
    }
    fun updateTitleError(type : Boolean){
        titleError = type
    }

    // to show in textfields
    fun updateDate(date : String){
        this.date = date
    }
    fun updateTime(time: String){
        this.time = time
    }

    // to use in room

     var dateRoom : Long by mutableLongStateOf(0)
     var timeRoom : String by mutableStateOf("")

    fun updateTimeRoom(time: String){
        timeRoom = time
    }
    fun updateDateRoom(time: Long){
        dateRoom = time
    }


// Room database

    lateinit var getAllReminder: Flow<List<Reminder>>

    init {
        viewModelScope.launch {
            getAllReminder = reminderRepo.getAllReminder()
        }
    }

    fun insert(reminder: Reminder){
        viewModelScope.launch(Dispatchers.IO) {
            reminderRepoo.insert(reminder)
        }
    }
    fun update(reminder: Reminder){
        viewModelScope.launch(Dispatchers.IO) {
            reminderRepoo.update(reminder)
        }
    }
    fun delete(reminder: Reminder){
        viewModelScope.launch(Dispatchers.IO) {
            reminderRepoo.delete(reminder)
        }
    }
}