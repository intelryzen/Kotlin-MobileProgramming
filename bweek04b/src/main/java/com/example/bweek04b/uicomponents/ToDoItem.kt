package com.example.bweek04b.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bweek04b.model.Item
import com.example.bweek04b.model.ToDoStatus

@Composable
fun ToDoItem(item: Item, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = item.content,
            fontSize = 16.sp,
            style = if (item.status == ToDoStatus.COMPLETED)
                TextStyle(
                    textDecoration = TextDecoration.LineThrough
                )
            else
                TextStyle(
                    textDecoration = TextDecoration.None
                )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = item.time,
            fontSize = 10.sp
        )
    }
}

@Preview
@Composable
private fun ToDoItemPreview() {
    Column {
        ToDoItem(
            item = Item("모프 공부하기", "03-18 12:46"),
            modifier = Modifier
        )
        ToDoItem(
            item = Item(
                "모프 공부하기",
                "03-18 12:46",
                ToDoStatus.COMPLETED
            ),
        )
    }
}