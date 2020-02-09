package com.example.bubble.photogallery

import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.example.bubble.photogallery.api.FlickrApi
import com.example.bubble.photogallery.model.GalleryItem
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotoRepository {
    private val flickrApi : FlickrApi
    val galleryItems = MutableLiveData<List<GalleryItem>>()
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.flickr.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        flickrApi = retrofit.create(FlickrApi::class.java)
    }

    @WorkerThread
    suspend fun fetchRemotePhotos(){
        val gItems = flickrApi.fetchPhotos().photos.galleryItems
        galleryItems.postValue(gItems)
    }

    fun refreshData(){
        CoroutineScope(Dispatchers.IO).launch {
            fetchRemotePhotos()
        }
    }
}