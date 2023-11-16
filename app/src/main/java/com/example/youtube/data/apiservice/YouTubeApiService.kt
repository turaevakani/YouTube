package com.example.youtube.data.apiservice

import com.example.youtube.data.model.PlayListItem
import com.example.youtube.data.model.Playlists
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApiService {

    @GET("playlists")
    fun getPlaylists(
        @Query("key") apiKey: String,
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("maxResults") maxResults: Int
    ): Call<Playlists>

    @GET("playlistItems")
     fun playlistItems(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("playlistId") id: String,
        @Query("maxResults") maxResults : Int
    ): Call<PlayListItem>

}