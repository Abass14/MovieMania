package com.example.moviemania.home.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "last_episode_to_air")
data class LastEpisodeToAir(
    val air_date: String,
    val episode_number: Int,
    @PrimaryKey
    val id: Int,
    val name: String,
    val overview: String,
    val production_code: String,
    val runtime: Int,
    val season_number: Int,
    val still_path: String,
    val vote_average: Double,
    val vote_count: Int
)