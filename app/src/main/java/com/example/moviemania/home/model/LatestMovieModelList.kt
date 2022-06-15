package com.example.moviemania.home.model


data class LatestMovieModelList(
    val page: Int,
    val results: List<LatestMovieModel>,
    val total_results: Int,
    val total_pages: Int
)
