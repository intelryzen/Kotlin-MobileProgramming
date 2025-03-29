package com.example.bweek04b.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bweek04b.model.Item
import com.example.bweek04b.model.ToDoItemFactory
import com.example.bweek04b.model.ToDoStatus

@Composable
fun ToDoList(toDoList: MutableList<Item>, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .verticalScroll(scrollState)
    ) {
        toDoList.forEachIndexed { index, item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(vertical = 10.dp),
                ) {
                    ToDoCheckBox(isChecked = item.status == ToDoStatus.COMPLETED) { status ->
                        toDoList[index] = item.copy(
                            status = if (status) {
                                ToDoStatus.COMPLETED
                            } else {
                                ToDoStatus.PENDING
                            }
                        )
                    }
                    ToDoItem(item)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Preview
@Composable
private fun ToDoListPreview() {
    ToDoList(ToDoItemFactory.makeToDoList())
}
