package com.example.bweek04b.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bweek04b.model.ToDoItemFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val toDoList = remember {
        ToDoItemFactory.makeToDoList()
    }
    var checked by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier.fillMaxHeight()
    ) {
        ToDoListTitle()
        ToDoSwitch(
            checked = checked,
            onCheckedChange = { value -> checked = value },
        )
        ToDoList(
            toDoList,
            isSwitchOn = checked,
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