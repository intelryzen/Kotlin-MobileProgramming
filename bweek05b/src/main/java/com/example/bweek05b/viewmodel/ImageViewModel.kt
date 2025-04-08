package com.example.bweek05b.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bweek05b.model.ImageData
import com.example.bweek05b.model.ImageListFactory

class ImageViewModel : ViewModel() {
    private val _imageList = ImageListFactory.makeImageList()
    val imageList : MutableList<ImageData>
        get() = _imageList
}