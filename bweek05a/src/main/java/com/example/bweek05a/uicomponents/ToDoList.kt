package com.example.bweek05a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.bweek05a.model.Item
import com.example.bweek05a.model.ToDoItemFactory
import com.example.bweek05a.model.ToDoStatus

@Composable
fun ToDoList(
    toDoList: MutableList<Item>,
    showOnlyPending: Boolean,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .verticalScroll(scrollState)
    ) {
        toDoList.forEachIndexed { index, item ->
            val isCompleted = item.status == ToDoStatus.COMPLETED

            if (showOnlyPending && isCompleted) {
                Spacer(modifier = Modifier.size(0.dp))
            } else {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .toggleable(
                            value = isCompleted,
                            onValueChange = { status ->
                                toDoList[index] = item.copy(
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
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Preview
@Composable
private fun ToDoListPreview() {
    ToDoList(ToDoItemFactory.makeToDoList(), showOnlyPending = false)
}
