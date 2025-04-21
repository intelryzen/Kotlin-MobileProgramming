package com.example.bweek05b.uicomponents

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import com.example.bweek05b.model.ImageUri

@Composable
fun ImageWithButton(
    image: ImageUri, modifier: Modifier = Modifier,
    button: @Composable () -> Unit
) { 
    val img = when (image) {
        is ImageUri.ResImage -> image.resID
        is ImageUri.WebImage -> image.urlStr
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AsyncImage(
            model = img,
            contentDescription = "",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            onState = { state ->
                when (state) {
                    is AsyncImagePainter.State.Success -> {
                        Log.d("img", "Image Load Success")
                    }

                    is AsyncImagePainter.State.Error -> {
                        Log.d("img", "${state.result.throwable.message}")
                    }

                    else -> {}
                }
            }
        )
        button()
    }
}


//@Preview
//@Composable
//private fun ImageWithButtonPreview() {
//    var likes by remember { mutableStateOf(0) }
//    var dislikes by remember { mutableStateOf(0) }
//
//    ImageWithButton(image = R.drawable.image1) {
//        ButtonWithEmoji(likes, dislikes, { likes++ }, { dislikes++ })
//    }
//}