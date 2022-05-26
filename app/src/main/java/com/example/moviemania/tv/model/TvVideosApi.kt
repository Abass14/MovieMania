package com.example.moviemania.tv.model

import TV_GET_VIDEOS
import com.example.moviemania.home.model.GetVideosModel
import retrofit2.http.GET
import retrofit2.http.Path

interface TvVideosApi {
    @GET(TV_GET_VIDEOS)
    suspend fun getTvShowVideo(@Path("tv_id") tv_id: Int) : GetVideosModel
}