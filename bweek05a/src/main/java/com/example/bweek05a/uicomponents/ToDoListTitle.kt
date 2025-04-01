package com.example.bweek05a.uicomponents

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bweek05a.R


@Composable
fun ToDoListTitle(modifier: Modifier = Modifier) {
    Text(
        modifier = Modifier.padding(start = 10.dp),
        text = stringResource(R.string.todolist_title),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Preview
@Composable
private fun ToDoListTitlePreview() {
    ToDoListTitle()
}