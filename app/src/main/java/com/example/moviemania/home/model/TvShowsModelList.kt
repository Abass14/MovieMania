package com.example.moviemania.home.model

import androidx.room.Entity

data class TvShowsModelList(
    val page: Int,
    val results: List<LatestTvShowModel>,
    val total_results: Int,
    val total_pages: Int
)
