package com.pronay.myapplication.nav

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pronay.myapplication.ui.screens.AddNewNote
import com.pronay.myapplication.ui.screens.HomeScreen
import com.pronay.myapplication.ui.AddNoteViewmodel
import com.pronay.myapplication.ui.screens.TrashScreen


@RequiresApi(Build.VERSION_CODES.O)
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
        composable(route = Route.Trash.name){
            TrashScreen(navController = navController, viewmodel = viewmodel)
        }
    }
}