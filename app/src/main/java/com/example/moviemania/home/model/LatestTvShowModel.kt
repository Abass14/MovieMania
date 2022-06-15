package com.example.moviemania.home.model

import androidx.room.Entity

@Entity(tableName = "latest_tv_shows", primaryKeys = ["id"])
data class LatestTvShowModel(
    override val backdrop_path: String,
    override val first_air_date: String,
    override val genre_ids: List<Int>,
    override val id: Int,
    override val name: String,
    override val origin_country: List<String>,
    override val original_language: String,
    override val original_name: String,
    override val overview: String,
    override val popularity: Double,
    override val poster_path: String,
    override val vote_average: Double,
    override val vote_count: Int
) : BaseTvShowsModel(
    backdrop_path, first_air_date, genre_ids, id, name, origin_country, original_language, original_name, overview, popularity, poster_path, vote_average, vote_count
)