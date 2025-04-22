package com.example.lastmidtest.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.lastmidtest.model.WssFriendModel

class WssViewModel : ViewModel() {
    private val _friends = mutableStateListOf<WssFriendModel>()
    val friends: SnapshotStateList<WssFriendModel>
        get() {
//            _friends.sortByDescending { it.clickCount }
            return _friends
        }
}