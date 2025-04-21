package com.example.assignment2withviewmodel.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.assignment2withviewmodel.model.DollElement

@Composable
fun HorizontalGridCheckbox(
    elements: MutableList<DollElement>,
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(120.dp)
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