package com.example.moviemania.movies.network

import MOVIE_TOP_RATED
import com.example.moviemania.home.model.MovieModel
import retrofit2.http.GET

interface TopMoviesApi {
    @GET(MOVIE_TOP_RATED)
    suspend fun getTopRatedMovies() : MovieModel
}