package com.example.moviemania.tv.repo

import com.example.moviemania.home.model.*
import com.example.moviemania.tv.network.*
import javax.inject.Inject

class TvShowsRepository @Inject constructor(
    private val popularTvApi: PopularTvApi,
    private val tvDetailsApi: TvDetailsApi,
    private val tvGenreApi: TvGenreApi,
    private val tvOnTheAirApi: TvOnTheAirApi,
    private val tvTopRatedApi: TvTopRatedApi,
    private val tvVideosApi: TvVideosApi
) : TvShowsRepoInterface {
    override fun getPopularTv(page: Int): TvShowsModelList {
        TODO("Not yet implemented")
    }

    override fun getTvDetails(tv_id: Int): TvShowsDetailModel {
        TODO("Not yet implemented")
    }

    override fun getTvGenre(): GenreModel {
        TODO("Not yet implemented")
    }

    override fun getTvOnTheAir(page: Int): TvShowsModelList {
        TODO("Not yet implemented")
    }

    override fun getTvTopRated(page: Int): TvShowsModelList {
        TODO("Not yet implemented")
    }

    override fun getTvVideos(tv_id: Int): GetVideosModel {
        TODO("Not yet implemented")
    }

}