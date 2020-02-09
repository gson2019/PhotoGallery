package com.example.bubble.photogallery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bubble.photogallery.PhotoRepository
import kotlinx.coroutines.launch

class PhotoGalleryViewModel : ViewModel() {
    private val photoRepository = PhotoRepository()
    val galleryItems = photoRepository.galleryItems
    init {
        refreshData()
    }
    private fun refreshData() {
        viewModelScope.launch {
            photoRepository.refreshData()
        }
    }
}