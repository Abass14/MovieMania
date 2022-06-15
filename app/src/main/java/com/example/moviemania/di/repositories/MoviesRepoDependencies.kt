package com.example.moviemania.di.repositories

import com.example.moviemania.di.database.AppDatabase
import com.example.moviemania.di.database.LatestMovieDao
import com.example.moviemania.movies.network.*
import com.example.moviemania.movies.repo.MovieRepository
import com.example.moviemania.movies.repo.MoviesRepoInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MoviesRepoDependencies {
    @Singleton
    @Provides
    fun provideMovieRepository(
        latestMoviesApi: LatestMoviesApi,
        movieDetailsApi: MovieDetailsApi,
        movieGenresApi: MovieGenresApi,
        movieVideosApi: MovieVideosApi,
        popularMoviesApi: PopularMoviesApi,
        topMoviesApi: TopMoviesApi,
        latestMovieDao: LatestMovieDao,
        appDatabase: AppDatabase
    ) : MoviesRepoInterface = MovieRepository(latestMoviesApi, movieDetailsApi, movieGenresApi, movieVideosApi, popularMoviesApi, topMoviesApi, latestMovieDao, appDatabase)
}