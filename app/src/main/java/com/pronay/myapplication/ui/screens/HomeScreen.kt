package com.pronay.myapplication.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.pronay.myapplication.nav.Route
import com.pronay.myapplication.ui.Scaffold.BottomBar
import com.pronay.myapplication.ui.Scaffold.TopApkBar
import com.pronay.myapplication.ui.Styles.BoldTextStyle
import com.pronay.myapplication.ui.Styles.NormalTextStyle
import com.pronay.myapplication.ui.viewmodel.AddNoteViewmodel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewmodel: AddNoteViewmodel) {
    Scaffold(
        topBar = {
                 TopApkBar(title = "Dashboard", navController = navController)
        },
        bottomBar = {
            BottomBar()
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Route.AddNewNote.name)
            }) {
                Icon(imageVector = Icons.Default.Add
                    , contentDescription = "")
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {

        }
    }
}