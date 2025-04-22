package com.example.lastmidtest.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lastmidtest.model.WssFriendModel
import com.example.lastmidtest.viewmodel.WssViewModel

@Composable
fun WssHomeScreen(
    viewModel: WssViewModel = viewModel(),
    onNavigate: (String, String, Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    var friendNameState by remember {
        mutableStateOf("")
    }
    var phoneState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            "201811200 우승식 친구등록",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        WssTextField(
            placeholder = "친구이름",
            onValueChange = { friendNameState = it },
            value = friendNameState
        )
        Spacer(modifier = Modifier.height(8.dp))
        WssTextField(
            placeholder = "전화번호",
            onValueChange = { phoneState = it },
            value = phoneState
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                viewModel.friends.add(
                    WssFriendModel(
                        name = friendNameState,
                        phone = phoneState,
                    )
                )
                friendNameState = ""
                phoneState = ""
            },
        ) { Text("추가하기") }
        Spacer(modifier = Modifier.height(8.dp))
        WssFriendList(
            friends = viewModel.friends,
            onNavigate = onNavigate
        )
    }
}