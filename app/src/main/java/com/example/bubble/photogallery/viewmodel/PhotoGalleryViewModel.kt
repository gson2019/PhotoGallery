package com.example.bubble.photogallery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bubble.photogallery.PhotoRepository
import com.example.bubble.photogallery.model.GalleryItem

class PhotoGalleryViewModel : ViewModel(){
    val galleryItemLiveData:LiveData<List<GalleryItem>>
    init {
        galleryItemLiveData = PhotoRepository().fetchRemotePhotos()
    }
}