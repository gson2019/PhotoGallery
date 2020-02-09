package com.example.bubble.photogallery.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bubble.photogallery.FlickrFetcher
import com.example.bubble.photogallery.R
import kotlinx.android.synthetic.main.fragment_photo_gallery.*

class PhotoGalleryFragment : Fragment() {

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

        val flickrLiveData: LiveData<String> = FlickrFetcher().fetchContents()

        flickrLiveData.observe(this, Observer {
                responseString ->
            Log.d("PhotoGalleryFragment", "Response Received: $responseString")
        })
    }

    companion object{
        fun newInstance() = PhotoGalleryFragment()
    }
}