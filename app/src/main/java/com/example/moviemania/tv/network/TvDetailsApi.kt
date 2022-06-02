package com.example.moviemania.tv.network

import TV_DETAILS
import com.example.moviemania.home.model.TvShowsDetailModel
import retrofit2.http.GET
import retrofit2.http.Path

interface TvDetailsApi {
    @GET(TV_DETAILS)
    suspend fun getTvShowDetails(@Path("tv_id") tv_id: Int) : TvShowsDetailModel
}