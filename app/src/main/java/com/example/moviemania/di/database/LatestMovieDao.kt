package com.example.moviemania.di.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviemania.home.model.LatestMovieModel
import com.example.moviemania.home.model.RecentMovieModel
import kotlinx.coroutines.flow.Flow

@Dao
interface LatestMovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLatestMovies(movie: List<LatestMovieModel>)

    @Query("SELECT * FROM movie_model_table ORDER BY id ASC")
    fun getLatestMovies() : Flow<List<LatestMovieModel>>

    @Query("DELETE FROM movie_model_table WHERE id=:id")
    suspend fun deleteLatestMovie(id: Int)

    @Query("DELETE FROM movie_model_table")
    suspend fun deleteAllLatestMovies()
}