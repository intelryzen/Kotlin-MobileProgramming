package com.example.bweek05b.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bweek05b.R
import com.example.bweek05b.model.ButtonType
import com.example.bweek05b.model.ImageData
import com.example.bweek05b.model.ImageUri
import com.example.bweek05b.viewmodel.ImageViewModel

@Composable
fun MainScreen(modifier: Modifier = Modifier, imageViewModel: ImageViewModel = viewModel()) {
    val imageList = imageViewModel.imageList
    val orientation = LocalConfiguration.current.orientation
    val state = rememberLazyListState()

//    val imgR = LocalContext.current.resources.getIdentifier(
//        "image1",
//        "drawable",
//        LocalContext.current.packageName
//    )

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        ImageList(state, imageList = imageList)
    } else {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageList(state, imageList = imageList)
        }
    }
}


// viewmodel 없이 saver 사용
@Composable
fun MainScreen2(modifier: Modifier = Modifier, imageViewModel: ImageViewModel = viewModel()) {
//    val imageList = imageViewModel.imageList
//    val orientation = LocalConfiguration.current.orientation
//    val state = rememberLazyListState()

    var img1 by rememberSaveable(stateSaver = ImageData.imageSaver) {
        mutableStateOf(
            ImageData(
                imageUri = ImageUri.ResImage(R.drawable.image1),
                buttonType = ButtonType.EMOJI,
                likes = 50,
                dislikes = 10
            )
        )
    }
    var img2 by rememberSaveable(stateSaver = ImageData.imageSaver) {
        mutableStateOf(
            ImageData(
                imageUri = ImageUri.ResImage(R.drawable.image2),
                buttonType = ButtonType.BADGE,
                likes = 50,
                dislikes = 10
            )
        )
    }
    var img3 by rememberSaveable(stateSaver = ImageData.imageSaver) {
        mutableStateOf(
            ImageData(
                imageUri = ImageUri.ResImage(R.drawable.baseline_3g_mobiledata_24),
                buttonType = ButtonType.ICON,
                likes = 50,
                dislikes = 10
            )
        )
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageWithButton(
            image = img1.imageUri,
        ) {
            ButtonWithEmoji(
                likes = img1.likes,
                dislikes = img1.dislikes,
                onClickLikes = {
                    img1 = img1.copy(likes = img1.likes + 1)
                },
                onClickDisLikes = {
                    img1 = img1.copy(dislikes = img1.dislikes + 1)
                }
            )

        }

        ImageWithButton(
            image = img2.imageUri,
        ) {
            ButtonWithBadge(
                likes = img2.likes,
                onClick = {
                    img2 = img2.copy(likes = img2.likes + 1)
                },
            )
        }

        ImageWithButton(
            image = img3.imageUri,
        ) {
            ButtonWithIcon(
                likes = img3.likes,
                onClick = {
                    img3 = img3.copy(likes = img3.likes + 1)
                },
            )
        }
    }
}