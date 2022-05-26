package com.example.moviemania.movies.network

import MOVIE_NOW_PLAYING
import com.example.moviemania.home.model.MovieModel
import retrofit2.http.GET

interface LatestMoviesApi {
    @GET(MOVIE_NOW_PLAYING)
    suspend fun getLatestMovies() : MovieModel
}