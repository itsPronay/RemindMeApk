package com.pronay.myapplication.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pronay.myapplication.ui.screens.AddNewNote
import com.pronay.myapplication.ui.screens.HomeScreen
import com.pronay.myapplication.ui.viewmodel.AddNoteViewmodel


@Composable
fun Nav(viewmodel: AddNoteViewmodel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.Home.name) {
        composable(route = Route.Home.name){
            HomeScreen(navController, viewmodel)
        }
        composable(route = Route.AddNewNote.name){
            AddNewNote(navController, viewmodel)
        }
    }
}