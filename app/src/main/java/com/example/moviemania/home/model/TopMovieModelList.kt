package com.example.moviemania.home.model

data class TopMovieModelList (
    val page: Int,
    val results: List<TopMovieModel>,
    val total_results: Int,
    val total_pages: Int
    )