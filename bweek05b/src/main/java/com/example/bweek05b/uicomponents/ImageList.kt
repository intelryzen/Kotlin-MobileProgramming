package com.example.bweek05b.uicomponents

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.bweek05b.model.ButtonType.BADGE
import com.example.bweek05b.model.ButtonType.EMOJI
import com.example.bweek05b.model.ButtonType.ICON
import com.example.bweek05b.model.ImageData
import com.example.bweek05b.uiexamples.ScrollToTopButton
import kotlinx.coroutines.launch

@Composable
fun ImageList(
    state: LazyListState,
    imageList: MutableList<ImageData>,
    modifier: Modifier = Modifier
) {
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
        ) {
            itemsIndexed(items = imageList) { index, item ->
                GetButton(index, item, imageList)
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

@Composable
fun GetButton(index: Int, item: ImageData, imageList: MutableList<ImageData>) {
    when (item.buttonType) {
        ICON -> {
            ImageWithButton(
                image = item.imageUri,
            ) {
                ButtonWithIcon(
                    likes = item.likes,
                    onClick = {
                        imageList[index] = item.copy(likes = item.likes + 1)
                    },
                )
            }
        }

        BADGE -> {
            ImageWithButton(
                image = item.imageUri,
            ) {
                ButtonWithBadge(
                    likes = item.likes,
                    onClick = {
                        imageList[index] = item.copy(likes = item.likes + 1)
                    },
                )
            }
        }

        EMOJI -> {
            ImageWithButton(
                image = item.imageUri,
            ) {
                ButtonWithEmoji(
                    likes = item.likes,
                    dislikes = item.dislikes,
                    onClickLikes = {
                        imageList[index] = item.copy(likes = item.likes + 1)
                    },
                    onClickDisLikes = {
                        imageList[index] = item.copy(dislikes = item.dislikes + 1)
                    }
                )
            }
        }
    }
}