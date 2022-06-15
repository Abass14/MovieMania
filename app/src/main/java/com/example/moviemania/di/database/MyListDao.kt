package com.example.moviemania.di.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviemania.home.model.MyListModel
import com.example.moviemania.home.model.RecentMovieModel
@Dao
interface MyListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteMovie(movie: MyListModel)

    @Query("SELECT * FROM my_list ORDER BY id ASC")
    fun getFavoriteMovies() : LiveData<List<MyListModel>>

    @Query("DELETE FROM my_list WHERE id=:id")
    suspend fun deleteFavoriteMovie(id: Int)

    @Query("DELETE FROM my_list")
    suspend fun deleteAllFavoriteMovies()
}