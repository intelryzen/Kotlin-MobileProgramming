package com.example.assignment2withviewmodel.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.assignment2withviewmodel.model.DollElement

@Composable
fun DollComponent(
    elements: SnapshotStateList<DollElement>,
    modifier: Modifier = Modifier
) {
//    val context = LocalContext.current
//    context.resources.getIdentifier(
//        "arms",
//        "drawable",
//        context.packageName
//    )

    Column {
        Text("201811200 우승식")
        Box(
            modifier = Modifier
                .size(200.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            elements.forEach { item ->
                if (item.show) {
                    Image(
                        painter = painterResource(id = item.id),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                    )
                }
            }
        }
    }
}