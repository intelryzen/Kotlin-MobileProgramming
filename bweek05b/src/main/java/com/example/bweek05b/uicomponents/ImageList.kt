package com.example.bweek05b.uicomponents
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bweek05b.model.ButtonType.BADGE
import com.example.bweek05b.model.ButtonType.EMOJI
import com.example.bweek05b.model.ButtonType.ICON
import com.example.bweek05b.model.ImageData

@Composable
fun ImageList(imageList: MutableList<ImageData>, modifier: Modifier = Modifier) {
    imageList.forEachIndexed { index, item ->
        when (item.buttonType) {
            ICON -> {
                ImageWithButton(
                    image = item.imageUri,
                ) {
                    ButtonWithIcon(
                        likes = item.likes,
                        onClick = {
                            imageList[index] = item.copy(likes = item.likes + 1)
                        },
                    )
                }
            }
            BADGE -> {
                ImageWithButton(
                    image = item.imageUri,
                ) {
                    ButtonWithBadge(
                        likes = item.likes,
                        onClick = {
                            imageList[index] = item.copy(likes = item.likes + 1)
                        },
                    )
                }
            }
            EMOJI -> {
                ImageWithButton(
                    image = item.imageUri,
                ) {
                    ButtonWithEmoji(
                        likes = item.likes,
                        dislikes = item.dislikes,
                        onClickLikes = {
                            imageList[index] = item.copy(likes = item.likes + 1)
                        },
                        onClickDisLikes = {
                            imageList[index] = item.copy(dislikes = item.dislikes + 1)
                        }
                    )
                }
            }
        }
    }
}