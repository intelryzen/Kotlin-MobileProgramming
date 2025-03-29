package com.example.bweek04b.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bweek04b.model.ToDoItemFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val toDoList = remember {
//        mutableStateListOf<Item>()
        ToDoItemFactory.makeToDoList()
    }

    Column() {
        ToDoListTitle(
            modifier = Modifier.weight(1f),
        )
        ToDoList(toDoList)
        ToDoItemInput(toDoList)
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}