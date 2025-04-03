package com.example.bweek05b.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.bweek05b.R
import com.example.bweek05b.model.ButtonType
import com.example.bweek05b.model.ImageData
import com.example.bweek05b.model.ImageUri

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val img1 = rememberSaveable(stateSaver = ImageData.imageSaver) {
        mutableStateOf(
            ImageData(
                imageUri = ImageUri.ResImage(R.drawable.image1),
                buttonType = ButtonType.EMOJI,
                likes = 50,
                dislikes = 10
            )
        )
    }
}