package com.example.moviemania.di.repositories

import com.example.moviemania.home.model.GenreModel
import com.example.moviemania.home.model.GetVideosModel
import com.example.moviemania.home.model.MovieDetailsModel
import com.example.moviemania.home.model.MovieModel

interface MoviesRepoInterface {
    fun getLatestMovies() : MovieModel
    fun getMovieDetails(movie_id: Int) : MovieDetailsModel
    fun getMovieGenres() : GenreModel
    fun getMovieVideos(movie_id: Int): GetVideosModel
    fun getPopularMovies() : MovieModel
    fun getTopMovies() : MovieModel
}