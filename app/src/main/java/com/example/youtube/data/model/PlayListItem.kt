package com.example.youtube.data.model

data class PlayListItem(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val pageInfo: PageInfo
)