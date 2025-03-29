package com.example.bweek04b.model

import androidx.compose.runtime.mutableStateListOf

object ToDoItemFactory {
    fun makeToDoList() = mutableStateListOf(
        Item("201811200 우승식 1", "03-18 12:46"),
        Item("201811200 우승식 2", "03-18 13:46", ToDoStatus.COMPLETED),
        Item("201811200 우승식 3", "03-18 14:46", ToDoStatus.COMPLETED),
    )
}