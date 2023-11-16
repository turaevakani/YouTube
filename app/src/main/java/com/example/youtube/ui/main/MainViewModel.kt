package com.example.youtube.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtube.data.model.Playlists
import com.example.youtube.data.repositories.YouTubeRepository

class MainViewModel (private val repository: YouTubeRepository) : ViewModel() {

  //  private val _playlists = MutableLiveData<Playlists>()
    ////val playlists: LiveData<Playlists> = _playlists

    fun getPlaylists():LiveData<Playlists>  {
       return repository.getPlaylists()
    }
}