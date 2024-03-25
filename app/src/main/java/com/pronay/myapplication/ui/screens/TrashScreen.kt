package com.pronay.myapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pronay.myapplication.data.Reminder
import com.pronay.myapplication.ui.AddNoteViewmodel
import com.pronay.myapplication.ui.Scaffold.NavBarBottom
import com.pronay.myapplication.ui.Scaffold.TopApkBar
import com.pronay.myapplication.ui.Styles.RemindDetailsStyle
import com.pronay.myapplication.ui.Styles.RemindTitleStyle
import milliSecondsToDate

@Composable
fun TrashScreen(navController: NavController, viewmodel: AddNoteViewmodel) {
    val reminderList = viewmodel.getAllReminder.collectAsState(initial = listOf())
    Scaffold(
        topBar = {
            TopApkBar(titleString = "Trash", navController = navController)
        },
        bottomBar = {
            NavBarBottom(navController = navController)
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(it),

            content = {
                items(reminderList.value) { remind ->
                    if (remind.deleted) { // wont pass deleted data into the home page
                        cardView(remind = remind, viewmodel = viewmodel)
                    }
                }
            })

    }
}

@Composable
fun cardView2(remind: Reminder, viewmodel: AddNoteViewmodel) {
    var showDetails by remember {
        mutableStateOf(true)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)

        ) {
            Column(
                modifier = Modifier.weight(.9f)
            ) {
                RemindTitleStyle(title = remind.title)
                Text(
                    text = remind.time + "( ${milliSecondsToDate(remind.date)} )",
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.Serif
                )
                if (showDetails) {
                    Divider(
                        modifier = Modifier.padding(8.dp)
                    )
                    RemindDetailsStyle(details = remind.details)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(onClick = {
                            remind.stared = true
                        }) {
                            Icon(
                                imageVector = Icons.Default.Star, contentDescription = "",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        IconButton(onClick = {
//                            remind.deleted = true
//                            viewmodel.update(remind)
                            viewmodel.insert(
                                Reminder(
                                    id = remind.id,
                                    title = remind.title,
                                    details = remind.details,
                                    date = remind.date,
                                    time = remind.time,
                                    stared = remind.stared,
                                    deleted = false
                                )
                            )
                            viewmodel.delete(remind)

                        }) {
                            Icon(
                                imageVector = Icons.Default.Refresh, contentDescription = "",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }

            }
            Column(
                modifier = Modifier.weight(.1f)
            ) {
                IconButton(onClick = {
                    showDetails = !showDetails
                }) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
                }
            }

        }
    }
}