package com.example.moviemania.di.network

import com.example.moviemania.di.retrofit.RetrofitInstance.Companion.provideRetrofitInstance
import com.example.moviemania.movies.network.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MoviesDependencies {

    @Singleton
    @Provides
    fun providesLatestMoviesApi() : LatestMoviesApi = provideRetrofitInstance().create(LatestMoviesApi::class.java)

    @Singleton
    @Provides
    fun providesMovieDetailsApi() : MovieDetailsApi = provideRetrofitInstance().create(MovieDetailsApi::class.java)

    @Singleton
    @Provides
    fun providesMovieGenreApi() : MovieGenresApi = provideRetrofitInstance().create(MovieGenresApi::class.java)

    @Singleton
    @Provides
    fun providesMovieVideosApi() : MovieVideosApi = provideRetrofitInstance().create(MovieVideosApi::class.java)

    @Singleton
    @Provides
    fun providesPopularMoviesApi() : PopularMoviesApi = provideRetrofitInstance().create(PopularMoviesApi::class.java)

    @Singleton
    @Provides
    fun providesTopMoviesApi() : TopMoviesApi = provideRetrofitInstance().create(TopMoviesApi::class.java)
}