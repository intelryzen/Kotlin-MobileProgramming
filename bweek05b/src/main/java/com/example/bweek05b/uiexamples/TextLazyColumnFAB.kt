package com.example.bweek05b.uiexamples

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun TextLazyColumnFAB(dataList: MutableList<String>, modifier: Modifier = Modifier) {
    val state = rememberLazyListState()
    val scope = rememberCoroutineScope()

    // mutableStateOf 로 하면 처음 0에서 상태가 바뀌지 않음. 다른 state 에 의존해서 상태가 바뀌어야 함.
    // 그냥 대입 연산자도 사용가능하지만 대입이 계속 일어남
    val showButton by remember {
        derivedStateOf {
            state.firstVisibleItemIndex > 0
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            state = state,
            modifier = modifier,
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = dataList) {item->
                TextCell(text = item, Modifier.background(Color.Green))
            }
        }
        AnimatedVisibility(visible = showButton) {
            ScrollToTopButton {
                scope.launch {
                    state.scrollToItem(0)
                }
            }
        }
    }
}

@Preview
@Composable
private fun TextLazyColumnFABPreview() {
    val dataList = (1..15).map { it.toString() }.toMutableList()
    TextLazyColumnFAB(dataList = dataList, modifier = Modifier.fillMaxSize())
}