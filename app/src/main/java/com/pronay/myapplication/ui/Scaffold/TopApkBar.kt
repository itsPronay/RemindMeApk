package com.pronay.myapplication.ui.Scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import com.pronay.myapplication.data.Reminder
import com.pronay.myapplication.nav.Route
import com.pronay.myapplication.ui.AddNoteViewmodel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopApkBar(
    titleString: String,
    navController: NavController,
    viewmodel: AddNoteViewmodel? = null
) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    TopAppBar(
        title = {
            Text(text = titleString)
        },
        navigationIcon = {
            if (titleString == "Dashboard") {
                IconButton(onClick = {

                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                }
            } else {
                IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
            }
        },
        actions = {
            if (titleString == "Dashboard") {
                IconButton(onClick = {
                    navController.navigate(Route.notifications.name)
                }) {
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = "")
                }
            } else {
                IconButton(onClick = {
                    if (viewmodel != null) {
                        if (viewmodel.title.trim() == "") {
                            viewmodel.updateSupportingText("Title can't be empty")
                            viewmodel.updateTitleError(true)
                        } else {
                            navController.navigateUp()
                            viewmodel.insert(
                                Reminder(
                                    title = viewmodel.title,
                                    details = viewmodel.details,
                                    date = viewmodel.dateRoom,
                                    time = viewmodel.timeRoom
                                )
                            )
                        }
                    } else {
                        navController.navigate(Route.notifications.name)
                    }
                }) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "")
                }
            }

        }
    )


}


//
//if(drawerState.isOpen){
//
//}
///*
//   for the drawer
//    */
