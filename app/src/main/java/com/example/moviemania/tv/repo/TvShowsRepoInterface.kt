package com.example.moviemania.tv.repo

import com.example.moviemania.home.model.*

interface TvShowsRepoInterface {
    fun getPopularTv(page: Int) : TvShowsModelList
    fun getTvDetails(tv_id: Int) : TvShowsDetailModel
    fun getTvGenre() : GenreModel
    fun getTvOnTheAir(page: Int) : TvShowsModelList
    fun getTvTopRated(page: Int) : TvShowsModelList
    fun getTvVideos(tv_id: Int) : GetVideosModel
}