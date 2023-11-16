package com.example.youtube.ui.second

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtube.data.model.PlayListItem
import com.example.youtube.data.repositories.YouTubeRepository

class SecondViewModel (private val repository: YouTubeRepository):ViewModel() {

    fun getPlaylistsItem(id:String): LiveData<PlayListItem> {
        return repository.getItem(id)
    }
}