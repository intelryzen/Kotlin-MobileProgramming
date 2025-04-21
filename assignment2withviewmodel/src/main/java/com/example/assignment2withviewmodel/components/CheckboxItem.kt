package com.example.assignment2withviewmodel.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment2withviewmodel.model.DollElement

@Composable
fun CheckboxItem(
    element: DollElement,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = element.show,
            onCheckedChange = onCheckedChange
        )
        Text(
            text = element.name,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}