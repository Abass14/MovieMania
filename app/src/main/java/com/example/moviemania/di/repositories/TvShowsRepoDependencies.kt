package com.example.moviemania.di.repositories

import com.example.moviemania.tv.network.*
import com.example.moviemania.tv.repo.TvShowsRepoInterface
import com.example.moviemania.tv.repo.TvShowsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TvShowsRepoDependencies {
    @Singleton
    @Provides
    fun providesTvShowsRepository(
        popularTvApi: PopularTvApi,
        tvDetailsApi: TvDetailsApi,
        tvGenreApi: TvGenreApi,
        tvOnTheAirApi: TvOnTheAirApi,
        tvTopRatedApi: TvTopRatedApi,
        tvVideosApi: TvVideosApi
    ) : TvShowsRepoInterface = TvShowsRepository(popularTvApi, tvDetailsApi, tvGenreApi, tvOnTheAirApi, tvTopRatedApi, tvVideosApi)
}