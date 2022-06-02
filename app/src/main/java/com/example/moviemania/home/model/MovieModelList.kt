package com.example.moviemania.home.model

data class MovieModelList(
    val page: Int,
    val results: List<MovieModel>,
    val total_results: Int,
    val total_pages: Int
)
