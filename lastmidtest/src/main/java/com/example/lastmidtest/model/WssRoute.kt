package com.example.lastmidtest.model

sealed class WssRoute(val route: String) {
    object WssHome : WssRoute("Home")
    object WssDetail : WssRoute("Detail")
}