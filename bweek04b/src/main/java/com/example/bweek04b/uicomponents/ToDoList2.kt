package com.example.bweek04b.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bweek04b.model.Item
import com.example.bweek04b.model.ToDoItemFactory
import com.example.bweek04b.model.ToDoStatus

@Composable
fun ToDoList2(
    toDoList: MutableList<Item>,
    isSwitchOn: Boolean,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    val displayList =
        if (isSwitchOn)
            toDoList.filter { it.status == ToDoStatus.PENDING }
        else
            toDoList

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .verticalScroll(scrollState)
    ) {
        displayList.forEachIndexed { _, item ->
            val pos = toDoList.indexOf(item)
            val isCompleted = item.status == ToDoStatus.COMPLETED

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .toggleable(
                        value = isCompleted,
                        onValueChange = { status ->
                            toDoList[pos] = item.copy(
                                status = if (status) {
                                    ToDoStatus.COMPLETED
                                } else {
                                    ToDoStatus.PENDING
                                }
                            )
                        },
                        role = Role.Checkbox,
                    )
            ) {
                Row(
                    modifier = Modifier
                        .padding(vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Spacer(modifier = Modifier.width(16.dp))
                    ToDoCheckBox(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        isChecked = isCompleted,
                        onCheckedChange = null,
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    ToDoItem(item)
                }
            }
        }
    }
}

@Preview
@Composable
private fun ToDoListPreview() {
    ToDoList(ToDoItemFactory.makeToDoList(), isSwitchOn = false)
}
