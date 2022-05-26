package com.example.moviemania.tv.model

import TV_POPULAR
import com.example.moviemania.home.model.TvShowModel
import retrofit2.http.GET

interface PopularTvApi {
    @GET(TV_POPULAR)
    suspend fun getPopularTvShows() : TvShowModel
}