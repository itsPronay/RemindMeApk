package com.pronay.myapplication.data

import android.icu.text.CaseMap.Title
import androidx.compose.runtime.Composable

data class Remind(

    val id : Int = 0,
    val title: String = "",
    val details: String = "N/A",
    val time: String = "",
    val date: String = "",
    var stared: Boolean = false,
    var deleted: Boolean = false
)


fun getDemoList(): MutableList<Remind> {
    val remindList = mutableListOf<Remind>()
    remindList.add(Remind(title = "Go to work", details = "Wake up and go to work", time = "10:15", date = "31-12-2003"))
    remindList.add(Remind(title = "Buy 1kg of tomato", details =  "for test", time =  "9:12", date = "23-3-2014"))

    return remindList
}