package com.example.moviemania.movies.network

import MOVIE_NOW_PLAYING
import com.example.moviemania.home.model.LatestMovieModelList
import retrofit2.http.GET
import retrofit2.http.Query

interface LatestMoviesApi {
    @GET(MOVIE_NOW_PLAYING)
    suspend fun getLatestMovies(@Query("page") page: Int) : LatestMovieModelList
}