package com.pronay.myapplication.ui.Scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import com.google.android.material.bottomappbar.BottomAppBar
import com.pronay.myapplication.ui.Styles.BoldTextStyle
import com.pronay.myapplication.ui.Styles.NormalTextStyle

data class BottomNavigationItem(
    val title: String,
    val isSelectedIcon: ImageVector,
    val notSelectedIcon: ImageVector,
    val badgeCount: Int ? = null,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar() {
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            isSelectedIcon = Icons.Filled.Home,
            notSelectedIcon = Icons.Outlined.Home,
        ),
        BottomNavigationItem(
            title = "Stared",
            isSelectedIcon = Icons.Filled.Star,
            notSelectedIcon = Icons.Outlined.Star
        ),
        BottomNavigationItem(
            title = "Trash",
            isSelectedIcon = Icons.Filled.Delete,
            notSelectedIcon = Icons.Outlined.Delete,
        )
    )
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(selected = (
                    selectedIndex == index
                    ),
                label = {
                    if (selectedIndex == index) {
                        BoldTextStyle(text = item.title)
                    } else {
                        NormalTextStyle(text = item.title)
                    }
                },
                onClick = {
                    selectedIndex = index
                },
                icon = {
                    BadgedBox(badge = {

                    }) {
                        if (selectedIndex == index) {
                            Icon(
                                imageVector = item.isSelectedIcon,
                                contentDescription = ""
                            )
                        } else {
                            Icon(
                                imageVector = item.notSelectedIcon,
                                contentDescription = ""
                            )
                        }
                    }
                })
        }
    }
}