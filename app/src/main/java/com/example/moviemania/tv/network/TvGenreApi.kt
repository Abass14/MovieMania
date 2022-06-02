package com.example.moviemania.tv.network

import TV_GENRE_LIST
import com.example.moviemania.home.model.GenreModel
import retrofit2.http.GET

interface TvGenreApi {
    @GET(TV_GENRE_LIST)
    suspend fun getTvGenreList() : GenreModel
}