package com.example.moviemania.movies.repo

import android.util.Log
import androidx.room.withTransaction
import com.example.moviemania.di.database.AppDatabase
import com.example.moviemania.di.database.LatestMovieDao
import com.example.moviemania.home.model.*
import com.example.moviemania.movies.network.*
import com.example.moviemania.utils.networkBoundResource
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val latestMoviesApi: LatestMoviesApi,
    private val movieDetailsApi: MovieDetailsApi,
    private val movieGenresApi: MovieGenresApi,
    private val movieVideosApi: MovieVideosApi,
    private val popularMoviesApi: PopularMoviesApi,
    private val topMoviesApi: TopMoviesApi,
    private val latestMovieDao: LatestMovieDao,
    private val appDatabase: AppDatabase
) : MoviesRepoInterface {
    override suspend fun getLatestMovies(page: Int) = networkBoundResource(
        query = {
            latestMovieDao.getLatestMovies()
        },
        fetch = {
            latestMoviesApi.getLatestMovies(page)
        },
        saveFetchedResult = { movieModelList ->
            appDatabase.withTransaction {
                latestMovieDao.deleteAllLatestMovies()
                latestMovieDao.insertLatestMovies(movieModelList.results)
            }
        },
        shouldFetch = {
            true
        }
    )

    override suspend fun getMovieDetails(movie_id: Int): MovieDetailsModel {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieGenres(): GenreModel {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieVideos(movie_id: Int): GetVideosModel {
        TODO("Not yet implemented")
    }

    override suspend fun getPopularMovies(page: Int): LatestMovieModelList {
        TODO("Not yet implemented")
    }

    override suspend fun getTopMovies(page: Int): TopMovieModelList {
        return topMoviesApi.getTopRatedMovies(page)
    }

}