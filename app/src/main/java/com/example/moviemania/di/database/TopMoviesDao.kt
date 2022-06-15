package com.example.moviemania.di.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviemania.home.model.TopMovieModel
@Dao
interface TopMoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopMovies(movie: List<TopMovieModel>)

    @Query("SELECT * FROM top_movie_table ORDER BY id ASC")
    fun getTopMovies() : LiveData<List<TopMovieModel>>

    @Query("DELETE FROM top_movie_table WHERE id=:id")
    suspend fun deleteTopMovie(id: Int)

    @Query("DELETE FROM top_movie_table")
    suspend fun deleteAllTopMovies()

}