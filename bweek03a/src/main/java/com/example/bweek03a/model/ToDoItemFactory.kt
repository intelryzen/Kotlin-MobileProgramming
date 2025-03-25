package com.example.bweek03a.model

object ToDoItemFactory {
    fun makeToDoList() = mutableListOf(
        Item("모프 공부하기1", "03-18 12:46"),
        Item("모프 공부하기2", "03-18 13:46", ToDoStatus.COMPLETED),
        Item("모프 공부하기3", "03-18 14:46", ToDoStatus.COMPLETED),
    )
}