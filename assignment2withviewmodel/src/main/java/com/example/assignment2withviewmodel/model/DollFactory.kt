package com.example.assignment2withviewmodel.model

import androidx.compose.runtime.mutableStateListOf
import com.example.assignment2withviewmodel.R

object DollFactory {
    fun makeElements() = mutableStateListOf<DollElement>(
        DollElement(R.drawable.body, "body"),
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
    )
}
