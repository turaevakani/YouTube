package com.example.youtube.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtube.data.apiservice.YouTubeApiService
import com.example.youtube.data.model.PlayListItem
import com.example.youtube.data.model.Playlists
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YouTubeRepository (private val api: YouTubeApiService) {

    fun getPlaylists(): LiveData<Playlists> {
        val result = MutableLiveData<Playlists>()

        val response = api.getPlaylists(
            "AIzaSyCSijeAePE7t_7ZSJ8HKszBRGOm9XNvkSU",
            "contentDetails,snippet",
            "UCWOA1ZGywLbqmigxE4Qlvuw",
            30
        )
        response.enqueue(object : Callback<Playlists> {
            override fun onResponse(call: Call<Playlists>, response: Response<Playlists>) {
                if (response.isSuccessful){
                    result.value = response.body()
                }
            }

            override fun onFailure(call: Call<Playlists>, t: Throwable) {
                Log.e("ololo", "onFailure:$result ", )
            }
        })
        return result
    }

    fun getItem(id:String):LiveData<PlayListItem>{
        val result = MutableLiveData<PlayListItem>()
        val response = api.playlistItems(
            "AIzaSyCSijeAePE7t_7ZSJ8HKszBRGOm9XNvkSU",
            "contentDetails,snippet",
            id,
            30
        )
        response.enqueue(object : Callback<PlayListItem> {
            override fun onResponse(call: Call<PlayListItem>, response: Response<PlayListItem>) {
                if (response.isSuccessful){
                    result.value = response.body()
                }
            }

            override fun onFailure(call: Call<PlayListItem>, t: Throwable) {
                Log.e("ololo", "onFailure:$result ", )
            }
        })
        return result
    }
}