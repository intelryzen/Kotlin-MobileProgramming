package com.example.lastmidtest.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun WssDetailScreen(
    name: String?,
    phone: String?,
    count: Int?,
    modifier: Modifier = Modifier,
) {
    Column {
        Text("상세정보", fontSize = 30.sp)
        Row {
            Text("이름 : ", fontSize = 20.sp)
            Text("$name")
        }
        Row {
            Text("휴대폰 번호 : ", fontSize = 20.sp)
            Text("$phone")
        }
        Row {
            Text("클릭 횟수 : ", fontSize = 20.sp)
            Text("$count 번")
        }
    }
}