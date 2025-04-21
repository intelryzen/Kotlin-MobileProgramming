package com.example.assignment2withviewmodel

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment2withviewmodel.components.DollComponent
import com.example.assignment2withviewmodel.components.HorizontalGridCheckbox
import com.example.assignment2withviewmodel.components.VerticalGridCheckbox
import com.example.assignment2withviewmodel.model.DollElement
import com.example.assignment2withviewmodel.model.DollFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val listSaver = listSaver<SnapshotStateList<DollElement>, Any>(
        save = { list ->
            list.flatMap { listOf<Any>(it.id, it.name, it.show) }
        },
        restore = { list ->
            list.chunked(3).map { (id, name, show) ->
                DollElement(id as Int, name as String, show as Boolean)
            }.toMutableStateList()
        }
    )

    val elements = rememberSaveable(
        saver = listSaver,
    ) {
        DollFactory.makeElements()
    }

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
fun PreviewMainComponent() {
    MainScreen()
}