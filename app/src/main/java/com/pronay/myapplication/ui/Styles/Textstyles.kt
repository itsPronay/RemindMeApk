package com.pronay.myapplication.ui.Styles

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

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