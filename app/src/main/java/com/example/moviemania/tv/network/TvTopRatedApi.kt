package com.example.moviemania.tv.network

import TV_TOP_RATED
import com.example.moviemania.home.model.TvShowModel
import com.example.moviemania.home.model.TvShowsModelList
import retrofit2.http.GET
import retrofit2.http.Query

interface TvTopRatedApi {
    @GET(TV_TOP_RATED)
    suspend fun getTvTopRated(@Query("page") page: Int) : TvShowsModelList
}