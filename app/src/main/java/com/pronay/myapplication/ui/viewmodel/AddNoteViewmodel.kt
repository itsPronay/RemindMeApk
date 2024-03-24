package com.pronay.myapplication.ui.viewmodel

import androidx.compose.material3.DatePickerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.LocalDateTime

class AddNoteViewmodel: ViewModel() {
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
    fun updateDate(date : String){
        this.date = date
    }
    fun updateTime(time: String){
        this.time = time
    }
}