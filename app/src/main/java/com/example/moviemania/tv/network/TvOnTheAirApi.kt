package com.example.moviemania.tv.network

import TV_ON_THE_AIR
import com.example.moviemania.home.model.TvShowsModelList
import retrofit2.http.GET
import retrofit2.http.Query

interface TvOnTheAirApi {
    @GET(TV_ON_THE_AIR)
    suspend fun getTvOnTheAir(@Query("page") page: Int) : TvShowsModelList
}