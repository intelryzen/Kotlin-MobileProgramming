package com.example.assignment2withviewmodel.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.assignment2withviewmodel.model.DollElement

@Composable
fun VerticalGridCheckbox(
    elements: MutableList<DollElement>,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(100.dp)
    ) {
        itemsIndexed(elements) { index, value ->
            CheckboxItem(
                element = value,
                onCheckedChange = { checked ->
                    elements[index] = value.copy(show = checked)
                }
            )
        }
    }
}
