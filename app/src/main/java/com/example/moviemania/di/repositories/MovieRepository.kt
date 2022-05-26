package com.example.moviemania.di.repositories

import com.example.moviemania.home.model.GenreModel
import com.example.moviemania.home.model.GetVideosModel
import com.example.moviemania.home.model.MovieDetailsModel
import com.example.moviemania.home.model.MovieModel
import com.example.moviemania.movies.network.*
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val latestMoviesApi: LatestMoviesApi,
    private val movieDetailsApi: MovieDetailsApi,
    private val movieGenresApi: MovieGenresApi,
    private val movieVideosApi: MovieVideosApi,
    private val popularMoviesApi: PopularMoviesApi,
    private val topMoviesApi: TopMoviesApi
) : MoviesRepoInterface {
    override fun getLatestMovies(): MovieModel {
        TODO("Not yet implemented")
    }

    override fun getMovieDetails(movie_id: Int): MovieDetailsModel {
        TODO("Not yet implemented")
    }

    override fun getMovieGenres(): GenreModel {
        TODO("Not yet implemented")
    }

    override fun getMovieVideos(movie_id: Int): GetVideosModel {
        TODO("Not yet implemented")
    }

    override fun getPopularMovies(): MovieModel {
        TODO("Not yet implemented")
    }

    override fun getTopMovies(): MovieModel {
        TODO("Not yet implemented")
    }

}