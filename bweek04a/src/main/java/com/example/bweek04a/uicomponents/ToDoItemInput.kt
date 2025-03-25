package com.example.bweek04a.uicomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bweek04a.model.Item
import com.example.bweek04a.model.ToDoItemFactory


@Composable
fun ToDoItemInput(toDoList: MutableList<com.example.bweek04a.model.Item>) {
    var textFieldState by remember { mutableStateOf("") }
    Row(modifier = Modifier.fillMaxWidth()) {
        TextField(
            value = textFieldState,
            onValueChange = {
                textFieldState = it
            },
            placeholder = {
                Text("할 일을 입력하세요.")
            }
        )
        Button(onClick = {  toDoList.add(
            com.example.bweek04a.model.Item(
                textFieldState,
                "03-18 12:46"
            )
        ) }) {
            Text("추가")
        }
    }
}

@Preview
@Composable
private fun ToDoItemInputPreview() {
    ToDoItemInput(toDoList = ToDoItemFactory.makeToDoList())
}