package com.example.moviemania.movies.repo

import com.example.moviemania.home.model.*
import com.example.moviemania.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MoviesRepoInterface {
    suspend fun getLatestMovies(page: Int) : Flow<Resource<List<LatestMovieModel>>>
    suspend fun getMovieDetails(movie_id: Int) : MovieDetailsModel
    suspend fun getMovieGenres() : GenreModel
    suspend fun getMovieVideos(movie_id: Int): GetVideosModel
    suspend fun getPopularMovies(page: Int) : LatestMovieModelList
    suspend fun getTopMovies(page: Int) : TopMovieModelList
}