package com.example.assignment2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DollComponent(
    visibleElements: Map<Int, Boolean>,
    modifier: Modifier = Modifier
) {
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
            if (visibleElements[id] == true) {
                Image(
                    painter = painterResource(id = id),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewDollComponent() {
    val allVisible = mapOf(
        R.drawable.arms to true,
        R.drawable.body to true,
        R.drawable.ears to true,
        R.drawable.eyebrows to true,
        R.drawable.eyes to true,
        R.drawable.glasses to true,
        R.drawable.hat to true,
        R.drawable.mouth to true,
        R.drawable.mustache to true,
        R.drawable.nose to true,
        R.drawable.shoes to true
    )
    DollComponent(visibleElements = allVisible)
}