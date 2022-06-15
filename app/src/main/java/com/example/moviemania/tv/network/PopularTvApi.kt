package com.example.moviemania.tv.network

import TV_POPULAR
import com.example.moviemania.home.model.TvShowsModelList
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularTvApi {
    @GET(TV_POPULAR)
    suspend fun getPopularTvShows(@Query("page") page: Int) : TvShowsModelList
}