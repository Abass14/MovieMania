package com.example.moviemania.movies.network

import MOVIE_DETAILS
import com.example.moviemania.home.model.MovieDetailsModel
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailsApi {
    @GET(MOVIE_DETAILS)
    suspend fun getMovieDetails(@Path("movie_id") movie_id: Int) : MovieDetailsModel
}