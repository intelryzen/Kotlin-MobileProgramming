package com.example.bweek05a.uicomponents

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ToDoCheckBox(
    isChecked: Boolean,
    modifier: Modifier = Modifier,
    onCheckedChange: ((Boolean) -> Unit)?
) {
    return Checkbox(
        checked = isChecked,
        onCheckedChange = onCheckedChange,
    )
}

@Preview
@Composable
private fun ToDoCheckBoxPreview() {
    ToDoCheckBox(true){}
}