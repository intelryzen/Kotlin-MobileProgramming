package com.example.assignment2

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class DollElement(val id: Int, val name: String)

@Composable
fun MainComponent(modifier: Modifier = Modifier) {
    val dollElements = listOf(
        DollElement(R.drawable.arms, "arms"),
        DollElement(R.drawable.ears, "ears"),
        DollElement(R.drawable.eyebrows, "eyebrows"),
        DollElement(R.drawable.eyes, "eyes"),
        DollElement(R.drawable.glasses, "glasses"),
        DollElement(R.drawable.hat, "hat"),
        DollElement(R.drawable.mouth, "mouth"),
        DollElement(R.drawable.mustache, "mustache"),
        DollElement(R.drawable.nose, "nose"),
        DollElement(R.drawable.shoes, "shoes"),
        DollElement(R.drawable.body, "body"),
    )

    val visibleElements = rememberSaveable(
        saver = listSaver(
            save = { map ->
                /// entries 는 set 을 반환함.
                /// val map = mutableMapOf(1 to true, 2 to false) 이라하면
                /// map.entries 는 (1, true)와 (2, false)를 각각 담은 객체들을 포함하는 셋
                /// flatMap은 이 셋의 각 엔트리에 대해 변환 작업을 수행하고
                /// 하나의 리스트로 평탄화 수행. 즉 최종 결과는 [1, 1, 2, 0]가 됨.

                map.entries.flatMap { listOf(it.key, if (it.value) 1 else 0) }
            },
            restore = { list ->
                val map = mutableStateMapOf<Int, Boolean>()
                for (i in list.indices step 2) {
                    // 혹시나 리스트의 길이가 홀수일 경우를 대비하여 오류를 방지하기 위해 i+1이 리스트의 길이보다 작은지 체크
                    if (i + 1 < list.size) {
                        map[list[i]] = (list[i + 1]) == 1
                    }
                }
                map
            }
        )
    ) {
        val map = mutableStateMapOf<Int, Boolean>()
        for (element in dollElements) {
            map[element.id] = true
        }
        map
    }

    val orientation = LocalConfiguration.current.orientation

    // 가로 모드일 경우
    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DollComponent(
                visibleElements = visibleElements,
                modifier = Modifier.weight(1f)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                CheckboxList(
                    dollElements = dollElements,
                    visibleElements = visibleElements
                )
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DollComponent(
                visibleElements = visibleElements,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                CheckboxList(
                    dollElements = dollElements,
                    visibleElements = visibleElements
                )
            }
        }
    }
}

@Composable
fun CheckboxList(
    dollElements: List<DollElement>,
    visibleElements: MutableMap<Int, Boolean>
) {
    dollElements.chunked(2).forEach { elements ->
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            elements.forEach { element ->
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    CheckboxItem(
                        element = element,
                        isChecked = visibleElements[element.id] ?: false,
                        onCheckedChange = { checked ->
                            visibleElements[element.id] = checked
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun CheckboxItem(
    element: DollElement,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange
        )
        Text(
            text = element.name,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewMainComponent() {
    MainComponent()
}