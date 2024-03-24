package com.pronay.myapplication.ui.screens

import android.app.TimePickerDialog
import android.widget.HorizontalScrollView
import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pronay.myapplication.ui.Scaffold.TopApkBar
import com.pronay.myapplication.ui.viewmodel.AddNoteViewmodel
import milliSecondsToDate
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewNote(navController: NavController, viewmodel: AddNoteViewmodel, supportingText : String? = "") {

    Scaffold(
        topBar = {
            TopApkBar(title = "Add new task", navController = navController, viewmodel = viewmodel)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .padding(it)
        ) {
            
            // this is for the datepicker

            var openDatePicker by remember {
                mutableStateOf(false)
            }
            var openTimePicker by remember {
                mutableStateOf(false)
            }
            val state = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
            val context =  LocalContext.current
            
            Row(
            ) {
                // for date picker
                TextField(value = viewmodel.date,
                    modifier = Modifier.weight(.6f),
                    onValueChange = {},
                    readOnly = true,
                    leadingIcon = {
                        IconButton(onClick = { openDatePicker = true }) {
                            Icon(imageVector = Icons.Default.DateRange
                                , contentDescription ="" )
                        }
                    },
                    label = {
                        Text(text = "Pick a date")
                    }
                )

                Spacer(modifier = Modifier.width(8.dp))
                // for time picker
                TextField(
                    modifier = Modifier.weight(.4f),
                    value = viewmodel.time,
                    onValueChange = {},
                    leadingIcon = {
                        IconButton(onClick = { openTimePicker = true }) {
                            Icon(imageVector = Icons.Default.Search
                                , contentDescription ="" )
                        }
                    },
                    label = {
                        Text(text = "Time")
                    },
                    readOnly = true,
                )
            }

            /*
            date picker logic
             */
            if(openDatePicker){
                DatePickerDialog(onDismissRequest = {
                    openDatePicker = false
                }, confirmButton = {
                    TextButton(onClick = {
                        openDatePicker = false
                        val date : String = milliSecondsToDate(state.selectedDateMillis)
                        viewmodel.updateDate(date)
                        Toast.makeText(context,"hey $date",Toast.LENGTH_LONG).show()
                    }) {
                        Text(text = "Ok")

                    }
                },
                    dismissButton = {
                        TextButton(onClick = {
                            openDatePicker = false
                        }) {
                            Text(text = "Cancel",
                                color = Color.Red
                            )
                        }

                    }
                ) {
                    DatePicker(state = state)
                }
            }

            /*
            time picker logic
             */

            val timeState = rememberTimePickerState(is24Hour = false)
            if(openTimePicker){
                AlertDialog(
                    onDismissRequest = { openDatePicker = false },
                    confirmButton = {
                                    TextButton(onClick = {
//                                        write code here for ok button






                                    }) {
                                        Text(text = "Ok")
                                    }
                                    },
                    dismissButton = {
                                    TextButton(onClick = { openTimePicker = false }) {
                                        Text(text = "Cancel",
                                            color  = Color.Red
                                            )
                                    }
                    },
                    text = {
                        TimePicker(state = timeState)
                    })
            }

            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = viewmodel.title,
                onValueChange = {
                    viewmodel.updateTitle(it)
                    if(viewmodel.title.trim()!=""){
                        viewmodel.updateTitleError(false)
                        viewmodel.updateSupportingText("")
                    }
                },
                isError = viewmodel.titleError,
                label = {
                    Text(text = "Enter title"
                    )
                },
                singleLine = true,
                supportingText = {
                    Text(text = viewmodel.supportingText,
                        color = Color.Red
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            TextField(
                value = viewmodel.details,
                onValueChange = {
                    viewmodel.updateDetails(it)
                },
                label = {
                    Text(text = "Enter Details")
                },
                supportingText = {
                    Text(text = "")
                },
                modifier = Modifier
                    .fillMaxSize()
            )



        }
    }


}

