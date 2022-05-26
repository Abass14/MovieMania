package com.example.moviemania.home.model

data class GetVideosModel(
    val id: Int,
    val results: List<VideoResult>
)

