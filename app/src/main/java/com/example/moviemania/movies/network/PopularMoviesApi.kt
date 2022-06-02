package com.example.moviemania.movies.network

import MOVIE_POPULAR
import com.example.moviemania.home.model.MovieModel
import com.example.moviemania.home.model.MovieModelList
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularMoviesApi {
    @GET(MOVIE_POPULAR)
    suspend fun getPopularMovies(@Query("page") page: Int) : MovieModelList
}