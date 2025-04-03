package com.example.bweek05b.model

import androidx.compose.runtime.saveable.listSaver

data class ImageData(
    val imageUri: ImageUri,
    val buttonType: ButtonType = ButtonType.ICON,
    var likes: Int = 0,
    var dislikes: Int = 0
) {
    companion object {
        val imageSaver = listSaver<ImageData, Any>(
            save = { item ->
                listOf(
                    when (item.imageUri) {
                        is ImageUri.ResImage -> item.imageUri.resID
                        is ImageUri.WebImage -> item.imageUri.urlStr
                    },
                    item.buttonType.name,
                    item.likes,
                    item.dislikes,
                )
            },
            restore = {list ->
                val imageValue = list[0]
                val image = when(imageValue) {
                    is Int -> ImageUri.ResImage(imageValue)
                    is String -> ImageUri.WebImage(imageValue)
                    else -> throw IllegalArgumentException("타입 오류")
                }
                ImageData(
                    imageUri = image,
                    buttonType = ButtonType.valueOf(list[1] as String),
                    likes = list[2] as Int,
                    dislikes = list[3] as Int
                )
            }
        )
    }
}