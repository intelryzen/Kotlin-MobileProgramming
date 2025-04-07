package com.example.assignment2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DollComponent(modifier: Modifier = Modifier) {
    val images = listOf(
        R.drawable.arms,
        R.drawable.body,
        R.drawable.ears,
        R.drawable.eyebrows,
        R.drawable.eyes,
        R.drawable.glasses,
        R.drawable.hat,
        R.drawable.mouth,
        R.drawable.mustache,
        R.drawable.nose,
        R.drawable.shoes,
    )

    Box() {
        images.forEach { id ->
            Image(
                painter = painterResource(id = id),
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )
        }
    }
}

@Preview
@Composable
private fun PreviewDollComponent() {
    DollComponent()
}