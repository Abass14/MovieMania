package com.example.moviemania.tv.model

import TV_TOP_RATED
import com.example.moviemania.home.model.TvShowModel
import retrofit2.http.GET

interface TvTopRatedApi {
    @GET(TV_TOP_RATED)
    suspend fun getTvTopRated() : TvShowModel
}