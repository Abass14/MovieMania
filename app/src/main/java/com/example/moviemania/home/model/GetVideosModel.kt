package com.example.moviemania.home.model

import androidx.room.Entity

data class GetVideosModel(
    val id: Int,
    val results: List<VideoResult>
)

