package com.pronay.myapplication.ui.Styles

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoldTextStyle(text: String) {
    Text(text = text,
        fontWeight = FontWeight.Bold
        )
}
@Composable
fun NormalTextStyle(text: String) {
    Text(text = text)
}

@Composable
fun RemindTitleStyle(title : String) {
    Text(text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        fontFamily = FontFamily.Monospace
        )
}

@Composable
fun RemindDetailsStyle(details : String) {
    Text(text = details,
        modifier = Modifier.padding(start = 24.dp),
        fontSize = 11.sp
    )
}