package com.example.moviemania.movies.network

import MOVIE_GET_VIDEOS
import com.example.moviemania.home.model.VideoResult
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieVideosApi {
    @GET(MOVIE_GET_VIDEOS)
    suspend fun getMovieVideos(@Path("movie_id") movie_id: Int) : VideoResult
}