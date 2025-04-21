package com.example.assignment2withviewmodel.viewmodel

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.assignment2withviewmodel.model.DollElement
import com.example.assignment2withviewmodel.model.DollFactory

class DollViewModel : ViewModel() {
    private var _list = DollFactory.makeElements()

    val list: SnapshotStateList<DollElement>
        get() = _list
}