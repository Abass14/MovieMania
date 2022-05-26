package com.example.moviemania.movies.network

import MOVIE_GENRE_LIST
import com.example.moviemania.home.model.GenreModel
import retrofit2.http.GET

interface MovieGenresApi {
    @GET(MOVIE_GENRE_LIST)
    suspend fun getMovieGenreList() : GenreModel
}