package com.example.week09.example03.model

import androidx.compose.ui.graphics.vector.ImageVector

data class BarItem(
    val title: String,
    val selectIcon: ImageVector,
    val onSelectedIcon: ImageVector,
    val route: String
)

