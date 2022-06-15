package com.example.moviemania.di.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviemania.home.model.RecentMovieModel
@Dao
interface RecentMoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecentMovies(movie: RecentMovieModel)

    @Query("SELECT * FROM recent_movies ORDER BY id ASC")
    fun getRecentMovies() : LiveData<List<RecentMovieModel>>

    @Query("DELETE FROM recent_movies WHERE id=:id")
    suspend fun deleteRecentMovie(id: Int)

    @Query("DELETE FROM recent_movies")
    suspend fun deleteAllRecentMovies()

}