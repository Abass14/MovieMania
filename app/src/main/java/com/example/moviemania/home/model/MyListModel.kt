package com.example.moviemania.home.model

import androidx.room.Entity

@Entity(tableName = "my_list", primaryKeys = ["id"])
data class MyListModel(
    override val adult: Boolean,
    override val backdrop_path: String? = null,
    override val genre_ids: List<Int>,
    override val id: Int,
    override val original_language: String,
    override val original_title: String,
    override val overview: String,
    override val popularity: Double,
    override val poster_path: String,
    override val release_date: String,
    override val title: String,
    override val video: Boolean,
    override val vote_average: Double,
    override val vote_count: Int
) : BaseMovieModel(
    adult, backdrop_path, genre_ids, id, original_language, original_title, overview, popularity, poster_path, release_date, title, video, vote_average, vote_count
)
