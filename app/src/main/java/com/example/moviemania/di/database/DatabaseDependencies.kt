package com.example.moviemania.di.database

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseDependencies {

    @Provides
    @Singleton
    fun provideAppDatabase (@ApplicationContext context: Context) : AppDatabase = AppDatabase.getDBInstance(context)

    @Provides
    @Singleton
    fun provideLatestMovieDao (appDatabase: AppDatabase) : LatestMovieDao = appDatabase.getLatestMoviesDao()

    @Provides
    @Singleton
    fun provideLatestTvShowsDao (appDatabase: AppDatabase) : LatestTvShowsDao = appDatabase.getLatestTvShowsDao()

    @Provides
    @Singleton
    fun provideTopMoviesDao (appDatabase: AppDatabase) : TopMoviesDao = appDatabase.getTopMoviesDao()

    @Provides
    @Singleton
    fun provideTopTvShowsDao (appDatabase: AppDatabase) : TopTvShowsDao = appDatabase.getTopTvShowsDao()

    @Provides
    @Singleton
    fun provideRecentMoviesDao (appDatabase: AppDatabase) : RecentMoviesDao = appDatabase.getRecentMoviesDao()

    @Provides
    @Singleton
    fun provideRecentTvShowsDao (appDatabase: AppDatabase) : RecentTvShowsDao = appDatabase.getRecentTvShowsDao()

    @Provides
    @Singleton
    fun provideMyList (appDatabase: AppDatabase) : MyListDao = appDatabase.getMyListDao()


}