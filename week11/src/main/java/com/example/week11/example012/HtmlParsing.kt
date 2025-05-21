package com.example.week11.example012

// 설치 라이브러리
// org.jsoup:jsoup
// androidx.compose.material:material

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FetchSongs(songViewModel: SongViewModel = viewModel()) {
    val songList = songViewModel.songList
    val isLoading = songViewModel.isLoading.value
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isLoading,
        onRefresh = { 
            songViewModel.fetchSongs()
        }
    )

    LaunchedEffect(Unit) {
        songViewModel.fetchSongs()
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .pullRefresh(pullRefreshState)
    ) {
        SongList(list = songList)
        PullRefreshIndicator(
            refreshing = isLoading,
            state = pullRefreshState,
            modifier = Modifier.align(
                Alignment.TopCenter
            )
        )
    }
}