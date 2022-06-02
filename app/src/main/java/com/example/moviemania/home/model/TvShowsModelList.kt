package com.example.moviemania.home.model

data class TvShowsModelList(
    val page: Int,
    val results: List<TvShowModel>,
    val total_results: Int,
    val total_pages: Int
)
