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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pronay.myapplication.data.Remind
import com.pronay.myapplication.data.getDemoList
import com.pronay.myapplication.nav.Route
import com.pronay.myapplication.ui.Scaffold.BottomBar
import com.pronay.myapplication.ui.Scaffold.TopApkBar
import com.pronay.myapplication.ui.Styles.RemindDetailsStyle
import com.pronay.myapplication.ui.Styles.RemindTitleStyle
import com.pronay.myapplication.ui.viewmodel.AddNoteViewmodel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewmodel: AddNoteViewmodel) {
    Scaffold(
        topBar = {
                 TopApkBar(titleString = "Dashboard", navController = navController)
        },
        bottomBar = {
            BottomBar(navController)
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
            modifier = Modifier.padding(it),
            content = {
                items(getDemoList()){
                    remind -> cardView(remind = remind)
                }
            }
        )

    }
}


@Composable
fun cardView(remind: Remind) {
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
                Text(text = remind.time +"( ${remind.date} )",
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.Serif
                    )
                if (showDetails){
                    Divider(
                        modifier = Modifier.padding(8.dp)
                    )
                    RemindDetailsStyle(details = remind.details)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Star
                                , contentDescription = "",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Delete
                                , contentDescription = "",
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