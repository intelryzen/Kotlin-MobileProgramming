package com.example.lastmidtest.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lastmidtest.model.WssFriendModel

@Composable
fun WssFriendList(
    friends: MutableList<WssFriendModel>,
    onNavigate: (String, String, Int) -> Unit,
    modifier: Modifier = Modifier,
) {
//    val sortedList by remember {
//        derivedStateOf {
//            friends.sortedByDescending { it.clickCount }
//        }
//    }

    LazyColumn {
        item {
            Box(
                modifier = Modifier
                    .background(
                        color = Color.LightGray
                    )
                    .fillMaxWidth()
                    .clickable {
                        friends.sortByDescending { it.clickCount }
                    },
                contentAlignment = Alignment.Center
            ) {
                Text("친구목록")
            }
        }
        itemsIndexed(items = friends) { index, model ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .background(Color.Yellow)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onNavigate(model.name, model.phone, model.clickCount)
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(model.name)
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = null,
                        tint = if (model.clickCount >= 5) Color.Red
                        else if (model.clickCount >= 3) Color.Green
                        else Color.LightGray,
                        modifier = Modifier.clickable {
//                            val pos = friends.indexOf(model)
                            friends[index] = model.copy(clickCount = model.clickCount + 1)
                        }
                    )
                }
            }
        }
    }
}