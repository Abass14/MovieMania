package com.example.moviemania.home.model

import androidx.room.PrimaryKey

abstract class BaseTvShowsModel(
    open val backdrop_path: String,
    open val first_air_date: String,
    open val genre_ids: List<Int>,
    open val id: Int,
    open val name: String,
    open val origin_country: List<String>,
    open val original_language: String,
    open val original_name: String,
    open val overview: String,
    open val popularity: Double,
    open val poster_path: String,
    open val vote_average: Double,
    open val vote_count: Int
) {
}