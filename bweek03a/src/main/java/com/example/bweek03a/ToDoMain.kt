package com.example.bweek03a

import com.example.bweek03a.model.ToDoItemFactory

fun printMenu() {
    println("학번 : 201811200 이름: 우승식")
    println("===== ToDo 리스트 메뉴 =====")
    println("1. 메모 등록")
    println("2. 메모 완료 체크")
    println("3. 메모 검색")
    println("4. 메모 전체 리스트 보기")
    println("5. 종료")
    print("메뉴 선택: ")
}

fun main() {
    val todoList = ToDoItemFactory.makeToDoList()
    val toDoService = ToDoService(todoList)

    while (
        true
    ) {
        printMenu();
        val input = readlnOrNull()

        when (input) {
            "1" -> {
                print("메모를 입력하세요: ")
                val content = readLine()
                if (content != null && content.isNotBlank()) {
                    toDoService.addContent(content)
                    println("메모가 등록되었습니다.")
                } else {
                    println("잘못된 입력입니다.")
                }
            }

            "2" -> {
                toDoService.listToDo()
                print("완료 체크할 메모의 인덱스를 입력하세요: ")
                val index = readlnOrNull()?.toIntOrNull()
                if (index != null && index in todoList.indices) {
                    toDoService.checkStatusCompleted(index)
                    println("메모가 완료로 처림됨: ${todoList[index]}")
                } else {
                    println("잘못된 입력입니다.")
                }
            }

            "3" -> {
                print("검색할 키워드를 입력하세요: ")
                val keyword = readLine()
                if (keyword != null && keyword.isNotBlank()) {
                    toDoService.searchContent(keyword)
                } else {
                    println("잘못된 입력입니다.")
                }
            }

            "4" -> toDoService.listToDo()

            "5" -> {
                println("프로그램을 종료합니다.")
                return
            }

            else -> println("잘못된 메뉴입니다.")
        }
    }

}