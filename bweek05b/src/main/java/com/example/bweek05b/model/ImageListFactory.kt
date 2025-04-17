package com.example.bweek05b.model

import androidx.compose.runtime.mutableStateListOf
import com.example.bweek05b.R

object ImageListFactory {
    fun makeImageList() = mutableStateListOf(
        ImageData(
            imageUri = ImageUri.ResImage(R.drawable.image1),
            buttonType = ButtonType.EMOJI,
            likes = 50,
            dislikes = 10
        ),
        ImageData(
            imageUri = ImageUri.ResImage(R.drawable.image2),
            buttonType = ButtonType.BADGE,
            likes = 50,
            dislikes = 10
        ),
        ImageData(
            imageUri = ImageUri.ResImage(R.drawable.baseline_3g_mobiledata_24),
            buttonType = ButtonType.ICON,
            likes = 50,
            dislikes = 10
        ),
        ImageData(
            imageUri = ImageUri.ResImage(R.drawable.baseline_3g_mobiledata_24),
            buttonType = ButtonType.ICON,
            likes = 50,
            dislikes = 10
        ), ImageData(
            imageUri = ImageUri.ResImage(R.drawable.baseline_3g_mobiledata_24),
            buttonType = ButtonType.ICON,
            likes = 50,
            dislikes = 10
        )

    )
}