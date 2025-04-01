package com.example.bweek05a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bweek05a.model.ToDoItemFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val toDoList = remember {
        ToDoItemFactory.makeToDoList()
    }
    val checked = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier.fillMaxHeight()
    ) {
        ToDoListTitle()
        ToDoSwitch(
            checked = checked.value,
            onCheckedChange = { value -> checked.value = value },
        )
        ToDoList(
            toDoList,
            showOnlyPending = checked.value,
            modifier = Modifier.weight(1f)
        )
        ToDoItemInput(toDoList)
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}