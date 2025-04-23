package com.example.lastmidtest.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.lastmidtest.R

@Composable
fun WssCircularImage(data: Any, modifier: Modifier = Modifier) {
    Row {
        Image(
            modifier = modifier
                .size(100.dp)                              // (1) 크기 지정
                .clip(CircleShape)                         // (2) 원형으로 자르기
                .border(4.dp, Color.Black, CircleShape),
            painter = painterResource(
                id = data as Int
            ),
            contentDescription = stringResource(id = R.string.text),
        )
        AsyncImage(
            model = data as Int,
            modifier = modifier
                .size(100.dp, 200.dp),
            contentScale = ContentScale.FillBounds,// (1) 크기 지정
            contentDescription = stringResource(id = R.string.text),
        )
    }

}

@Preview
@Composable
private fun WssPreviewCircularImage() {
    WssCircularImage(data = R.drawable.image4)
}