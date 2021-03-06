package com.example.moviemania.home.model

import ARCANE
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_model_table", primaryKeys = ["id"])
data class LatestMovieModel(
    @SerializedName("adult")
     val adult: Boolean,
    @SerializedName("backdrop_path")
     val backdrop_path: String? = null,
    @SerializedName("genre_ids")
     val genre_ids: List<Int>,
    @SerializedName("id")
     val id: Int,
    @SerializedName("original_language")
     val original_language: String,
    @SerializedName("original_title")
     val original_title: String,
    @SerializedName("overview")
     val overview: String,
    @SerializedName("popularity")
     val popularity: Double,
    @SerializedName("poster_path")
     val poster_path: String,
    @SerializedName("release_date")
     val release_date: String,
    @SerializedName("title")
     val title: String,
    @SerializedName("video")
     val video: Boolean,
    @SerializedName("vote_average")
     val vote_average: Double,
    @SerializedName("vote_count")
    val vote_count: Int
)
//    : BaseMovieModel(
//    adult, backdrop_path, genre_ids, id, original_language, original_title, overview, popularity, poster_path, release_date, title, video, vote_average, vote_count
//)