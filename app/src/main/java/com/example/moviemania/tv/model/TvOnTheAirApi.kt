package com.example.moviemania.tv.model

import TV_ON_THE_AIR
import com.example.moviemania.home.model.TvShowModel
import retrofit2.http.GET

interface TvOnTheAirApi {
    @GET(TV_ON_THE_AIR)
    suspend fun getTvOnTheAir() : TvShowModel
}