package com.example.moviemania.di.repositories

import com.example.moviemania.home.model.GenreModel
import com.example.moviemania.home.model.GetVideosModel
import com.example.moviemania.home.model.TvShowModel
import com.example.moviemania.home.model.TvShowsDetailModel

interface TvShowsRepoInterface {
    fun getPopularTv() : TvShowModel
    fun getTvDetails(tv_id: Int) : TvShowsDetailModel
    fun getTvGenre() : GenreModel
    fun getTvOnTheAir() : TvShowModel
    fun getTvTopRated() : TvShowModel
    fun getTvVideos(tv_id: Int) : GetVideosModel
}