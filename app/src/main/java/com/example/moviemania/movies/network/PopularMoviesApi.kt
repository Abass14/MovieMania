package com.example.moviemania.movies.network

import MOVIE_POPULAR
import com.example.moviemania.home.model.MovieModel
import retrofit2.http.GET

interface PopularMoviesApi {
    @GET(MOVIE_POPULAR)
    suspend fun getPopularMovies() : MovieModel
}