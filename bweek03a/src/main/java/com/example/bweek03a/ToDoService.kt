package com.example.bweek03a

import com.example.bweek03a.model.Item
import com.example.bweek03a.model.ToDoStatus
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ToDoService(val todoList: MutableList<Item>) {
    fun listToDo() {
        if (todoList.isEmpty()) {
            println("등록된 일정이 없습니다.")
        } else {
            todoList.forEachIndexed { index, item -> println("$index: $item") }
        }
    }

    fun addContent(content: String) {
        val currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))
        todoList.add(Item(content, currentTime))
    }

    fun checkStatusCompleted(index: Int) {
        todoList[index].status = ToDoStatus.COMPLETED
    }

    fun searchContent(keyword: String) {
        todoList.filter { it.content.contains(keyword) }.forEachIndexed { index, item -> println("$index: $item") }
    }
}