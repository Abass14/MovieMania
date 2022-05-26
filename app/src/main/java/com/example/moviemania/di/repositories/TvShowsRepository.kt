package com.example.moviemania.di.repositories

import com.example.moviemania.home.model.GenreModel
import com.example.moviemania.home.model.GetVideosModel
import com.example.moviemania.home.model.TvShowModel
import com.example.moviemania.home.model.TvShowsDetailModel
import com.example.moviemania.tv.model.*
import javax.inject.Inject

class TvShowsRepository @Inject constructor(
    private val popularTvApi: PopularTvApi,
    private val tvDetailsApi: TvDetailsApi,
    private val tvGenreApi: TvGenreApi,
    private val tvOnTheAirApi: TvOnTheAirApi,
    private val tvTopRatedApi: TvTopRatedApi,
    private val tvVideosApi: TvVideosApi
) : TvShowsRepoInterface {
    override fun getPopularTv(): TvShowModel {
        TODO("Not yet implemented")
    }

    override fun getTvDetails(tv_id: Int): TvShowsDetailModel {
        TODO("Not yet implemented")
    }

    override fun getTvGenre(): GenreModel {
        TODO("Not yet implemented")
    }

    override fun getTvOnTheAir(): TvShowModel {
        TODO("Not yet implemented")
    }

    override fun getTvTopRated(): TvShowModel {
        TODO("Not yet implemented")
    }

    override fun getTvVideos(tv_id: Int): GetVideosModel {
        TODO("Not yet implemented")
    }

}