package com.example.assignment2withviewmodel.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment2withviewmodel.model.DollElement
import kotlinx.coroutines.launch

@Composable
fun HorizontalGridCheckbox(
    elements: MutableList<DollElement>,
) {
    val state = rememberLazyGridState()
    val scope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf {
            state.firstVisibleItemIndex > 0
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyHorizontalGrid(
            state = state,
            rows = GridCells.Fixed(2),
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
        AnimatedVisibility(
            visible = showButton
        ) {
            ScrollToTopButton {
                scope.launch {
                    state.scrollToItem(0)
                }
            }
        }
    }
}