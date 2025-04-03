package com.example.bweek05b.model

sealed class ImageUri {
    data class ResImage(val resID:Int) : ImageUri()
    data class WebImage(val urlStr:String): ImageUri()
}