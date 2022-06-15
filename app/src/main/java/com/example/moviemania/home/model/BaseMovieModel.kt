package com.example.moviemania.home.model

abstract class BaseMovieModel(
    open val adult: Boolean,
    open val backdrop_path: String?,
    open val genre_ids: List<Int>,
    open val id: Int,
    open val original_language: String,
    open val original_title: String,
    open val overview: String,
    open val popularity: Double,
    open val poster_path: String,
    open val release_date: String,
    open val title: String,
    open val video: Boolean,
    open val vote_average: Double,
    open val vote_count: Int
) {
}