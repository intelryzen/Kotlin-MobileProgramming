package com.example.bweek05a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.bweek05a.R

@Composable
fun ImageWithButton(
    image: Int, modifier: Modifier = Modifier,
    button: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AsyncImage(
            model = image,
            contentDescription = "",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        button()
    }
}

@Composable
fun ImageWithButton(
    image: String, modifier: Modifier = Modifier,
    button: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AsyncImage(
            model = image,
            contentDescription = "",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        button()
    }
}

@Preview
@Composable
private fun ImageWithButtonPreview() {
    var likes by remember { mutableStateOf(0) }
    var dislikes by remember { mutableStateOf(0) }

    ImageWithButton(image = R.drawable.image1) {
        ButtonWithEmoji(likes, dislikes, { likes++ }, { dislikes++ })
    }
}