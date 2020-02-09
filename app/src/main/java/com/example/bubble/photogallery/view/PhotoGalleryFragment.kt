package com.example.bubble.photogallery.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bubble.photogallery.FlickrFetcher
import com.example.bubble.photogallery.R
import com.example.bubble.photogallery.model.GalleryItem
import com.example.bubble.photogallery.viewmodel.PhotoGalleryViewModel
import kotlinx.android.synthetic.main.fragment_photo_gallery.*

class PhotoGalleryFragment : Fragment() {
    private lateinit var photoGalleryViewModel: PhotoGalleryViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_photo_gallery, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photoRcv.layoutManager = GridLayoutManager(context, 2)

        photoGalleryViewModel = ViewModelProvider(this).get(PhotoGalleryViewModel::class.java)

        photoGalleryViewModel.galleryItemLiveData.observe(viewLifecycleOwner, Observer {
                galleryItems ->
            Log.d("FLickrFetcher", "Observe gallery Data: $galleryItems")
        })
    }

    companion object{
        fun newInstance() = PhotoGalleryFragment()
    }
}