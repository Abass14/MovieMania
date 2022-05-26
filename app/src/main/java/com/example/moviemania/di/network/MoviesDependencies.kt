package com.example.moviemania.di.network

import com.example.moviemania.di.retrofit.RetrofitInstance
import com.example.moviemania.movies.network.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MoviesDependencies @Inject constructor(private val retrofitInstance: Retrofit) {

    @Singleton
    @Provides
    fun providesLatestMoviesApi() : LatestMoviesApi = retrofitInstance.create(LatestMoviesApi::class.java)

    @Singleton
    @Provides
    fun providesMovieDetailsApi() : MovieDetailsApi = retrofitInstance.create(MovieDetailsApi::class.java)

    @Singleton
    @Provides
    fun providesMovieGenreApi() : MovieGenresApi = retrofitInstance.create(MovieGenresApi::class.java)

    @Singleton
    @Provides
    fun providesMovieVideosApi() : MovieVideosApi = retrofitInstance.create(MovieVideosApi::class.java)

    @Singleton
    @Provides
    fun providesPopularMoviesApi() : PopularMoviesApi = retrofitInstance.create(PopularMoviesApi::class.java)

    @Singleton
    @Provides
    fun providesTopMoviesApi() : TopMoviesApi = retrofitInstance.create(TopMoviesApi::class.java)
}