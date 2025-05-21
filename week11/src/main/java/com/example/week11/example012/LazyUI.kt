package com.example.week11.example012

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class SongData(
    val rank: Int,
    val title: String,
    val artist: String,
)

@Composable
fun SongItem(song: SongData) {
    val context = LocalContext.current
    Column (
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clickable {
//            val intent = Intent(Intent.ACTION_VIEW, news.newsUrl.toUri())
//            context.startActivity(intent)
//        }
    ) {
        Text("랭킹: " + song.rank.toString(), fontSize = 20.sp)
        Text("노래명: " + song.title, fontSize = 20.sp)
        Text("가수명: " + song.artist, fontSize = 20.sp)
    }
}

@Composable
fun SongList(list: List<SongData>) {
    LazyColumn {
        items(list) { item ->
            SongItem(item)
            HorizontalDivider(color = Color.Black, thickness = 1.dp)
        }
    }
}
