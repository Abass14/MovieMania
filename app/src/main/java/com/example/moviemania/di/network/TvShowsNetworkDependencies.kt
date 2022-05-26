package com.example.moviemania.di.network

import com.example.moviemania.movies.network.PopularMoviesApi
import com.example.moviemania.tv.model.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn
class TvShowsNetworkDependencies @Inject constructor(private val retrofit: Retrofit) {

    @Singleton
    @Provides
    fun providesPopularTvApi () : PopularTvApi = retrofit.create(PopularTvApi::class.java)

    @Singleton
    @Provides
    fun providesTvDetailsApi () : TvDetailsApi = retrofit.create(TvDetailsApi::class.java)

    @Singleton
    @Provides
    fun providesTvGenreApi () : TvGenreApi = retrofit.create(TvGenreApi::class.java)

    @Singleton
    @Provides
    fun providesTvOnTheAirApi () : TvOnTheAirApi = retrofit.create(TvOnTheAirApi::class.java)

    @Singleton
    @Provides
    fun providesTvTopRatedApi () : TvTopRatedApi = retrofit.create(TvTopRatedApi::class.java)

    @Singleton
    @Provides
    fun providesTvVideoApi () : TvVideosApi = retrofit.create(TvVideosApi::class.java)
}