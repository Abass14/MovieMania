package com.example.moviemania.movies.network

import MOVIE_TOP_RATED
import com.example.moviemania.home.model.MovieModel
import com.example.moviemania.home.model.MovieModelList
import retrofit2.http.GET
import retrofit2.http.Query

interface TopMoviesApi {
    @GET(MOVIE_TOP_RATED)
    suspend fun getTopRatedMovies(@Query("page") page: Int) : MovieModelList
}