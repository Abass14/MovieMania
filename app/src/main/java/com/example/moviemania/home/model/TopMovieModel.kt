package com.example.moviemania.home.model

import androidx.room.Entity

@Entity(tableName = "top_movie_table", primaryKeys = ["id"])
data class TopMovieModel (
     val adult: Boolean,
     val backdrop_path: String? = null,
     val genre_ids: List<Int>,
     val id: Int,
     val original_language: String,
     val original_title: String,
     val overview: String,
     val popularity: Double,
     val poster_path: String,
     val release_date: String,
     val title: String,
     val video: Boolean,
     val vote_average: Double,
     val vote_count: Int
)