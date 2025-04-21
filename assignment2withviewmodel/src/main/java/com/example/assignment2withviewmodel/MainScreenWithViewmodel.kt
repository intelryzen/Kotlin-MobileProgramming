package com.example.assignment2withviewmodel

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.assignment2withviewmodel.components.DollComponent
import com.example.assignment2withviewmodel.components.HorizontalGridCheckbox
import com.example.assignment2withviewmodel.components.VerticalGridCheckbox
import com.example.assignment2withviewmodel.viewmodel.DollViewModel

@Composable
fun MainScreenWithViewmodel(
    modifier: Modifier = Modifier,
    viewModel: DollViewModel = viewModel()
) {
    val elements = viewModel.list
    val orientation = LocalConfiguration.current.orientation

    // 가로 모드일 경우
    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DollComponent(
                elements = elements,
                modifier = Modifier.weight(1f)
            )
            HorizontalGridCheckbox(
                elements = elements,
            )
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DollComponent(
                elements = elements,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            VerticalGridCheckbox(
                elements = elements,
            )
        }
    }
}


@Preview
@Composable
fun PreviewMainComponent2() {
    MainScreenWithViewmodel()
}