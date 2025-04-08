package com.example.bweek05b.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bweek05b.viewmodel.ImageViewModel

@Composable
fun MainScreen(modifier: Modifier = Modifier, imageViewModel: ImageViewModel = viewModel()) {
    val imageList = imageViewModel.imageList
    val scrollState = rememberScrollState()
    val orientation = LocalConfiguration.current.orientation

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ImageList(imageList = imageList)
        }
    } else {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .horizontalScroll(scrollState),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageList(imageList = imageList)
        }
    }


//    var img1 by rememberSaveable(stateSaver = ImageData.imageSaver) {
//        mutableStateOf(
//            ImageData(
//                imageUri = ImageUri.ResImage(R.drawable.image1),
//                buttonType = ButtonType.EMOJI,
//                likes = 50,
//                dislikes = 10
//            )
//        )
//    }
//    var img2 by rememberSaveable(stateSaver = ImageData.imageSaver) {
//        mutableStateOf(
//            ImageData(
//                imageUri = ImageUri.ResImage(R.drawable.image2),
//                buttonType = ButtonType.BADGE,
//                likes = 50,
//                dislikes = 10
//            )
//        )
//    }
//    var img3 by rememberSaveable(stateSaver = ImageData.imageSaver) {
//        mutableStateOf(
//            ImageData(
//                imageUri = ImageUri.ResImage(R.drawable.baseline_3g_mobiledata_24),
//                buttonType = ButtonType.ICON,
//                likes = 50,
//                dislikes = 10
//            )
//        )
//    }
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        ImageWithButton(
//            image = img1.imageUri,
//        ) {
//            ButtonWithEmoji(
//                likes = img1.likes,
//                dislikes =img1.dislikes,
//                onClickLikes = {
//                    img1 = img1.copy(likes = img1.likes+1)
//                },
//                onClickDisLikes = {
//                    img1 = img1.copy(dislikes = img1.dislikes+1)
//                }
//            )
//
//        }
//
//        ImageWithButton(
//            image = img2.imageUri,
//        ) {
//            ButtonWithBadge(
//                likes = img2.likes,
//                onClick = {
//                    img2 = img2.copy(likes = img2.likes + 1)
//                },
//            )
//        }
//
//        ImageWithButton(
//            image = img3.imageUri,
//        ) {
//            ButtonWithIcon(
//                likes = img3.likes,
//                onClick = {
//                    img3 = img3.copy(likes = img3.likes + 1)
//                },
//            )
//        }
//    }
}