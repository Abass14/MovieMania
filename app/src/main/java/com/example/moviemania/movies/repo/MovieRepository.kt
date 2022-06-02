package com.example.moviemania.movies.repo

import com.example.moviemania.home.model.*
import com.example.moviemania.movies.network.*
import com.example.moviemania.movies.repo.MoviesRepoInterface
import java.lang.Exception
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val latestMoviesApi: LatestMoviesApi,
    private val movieDetailsApi: MovieDetailsApi,
    private val movieGenresApi: MovieGenresApi,
    private val movieVideosApi: MovieVideosApi,
    private val popularMoviesApi: PopularMoviesApi,
    private val topMoviesApi: TopMoviesApi
) : MoviesRepoInterface {
    override suspend fun getLatestMovies(page: Int): MovieModelList {
        return latestMoviesApi.getLatestMovies(page)
    }

    override suspend fun getMovieDetails(movie_id: Int): MovieDetailsModel {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieGenres(): GenreModel {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieVideos(movie_id: Int): GetVideosModel {
        TODO("Not yet implemented")
    }

    override suspend fun getPopularMovies(page: Int): MovieModelList {
        TODO("Not yet implemented")
    }

    override suspend fun getTopMovies(page: Int): MovieModelList {
        TODO("Not yet implemented")
    }

}