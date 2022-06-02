package com.example.moviemania.movies.repo

import com.example.moviemania.home.model.*

interface MoviesRepoInterface {
    suspend fun getLatestMovies(page: Int) : MovieModelList
    suspend fun getMovieDetails(movie_id: Int) : MovieDetailsModel
    suspend fun getMovieGenres() : GenreModel
    suspend fun getMovieVideos(movie_id: Int): GetVideosModel
    suspend fun getPopularMovies(page: Int) : MovieModelList
    suspend fun getTopMovies(page: Int) : MovieModelList
}