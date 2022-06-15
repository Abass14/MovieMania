package com.example.moviemania.di.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviemania.home.model.TopMovieModel
import com.example.moviemania.home.model.TopTvShowsModel
@Dao
interface TopTvShowsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopTvShows(tv: List<TopTvShowsModel>)

    @Query("SELECT * FROM top_tv_shows ORDER BY id ASC")
    fun getTopTvShows() : LiveData<List<TopTvShowsModel>>

    @Query("DELETE FROM top_tv_shows WHERE id=:id")
    suspend fun deleteTopTvShow(id: Int)

    @Query("DELETE FROM top_tv_shows")
    suspend fun deleteAllTopTvShows()
}