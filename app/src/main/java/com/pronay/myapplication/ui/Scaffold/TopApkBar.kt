package com.pronay.myapplication.ui.Scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.pronay.myapplication.nav.Route
import com.pronay.myapplication.ui.viewmodel.AddNoteViewmodel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopApkBar(title: String, navController: NavController, viewmodel: AddNoteViewmodel? = null) {
    TopAppBar(
        title = { title },
        navigationIcon = {
            if (title == "Dashboard"){
                IconButton(onClick = {
                    navController.navigate(Route.AddNewNote.name)
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                }
            }
            else{
                IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
            }
        },
        actions = {
            if (title == "Dashboard"){
                IconButton(onClick = {
                    navController.navigate(Route.notifications.name)
                }) {
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = "")
                }
            }
            else{
                IconButton(onClick = {
                    if (viewmodel != null) {
                        if(viewmodel.title.trim()==""){
                            viewmodel.updateSupportingText("Title can't be empty")
                            viewmodel.updateTitleError(true)
                        }
                        else{
                            navController.navigateUp()
                        }
                    }
                    else{
                        navController.navigate(Route.notifications.name)
                    }
                }) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "")
                }
            }
        }
    )
}