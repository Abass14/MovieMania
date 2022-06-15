package com.example.moviemania.di.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviemania.home.model.RecentTvSowsModel
import com.example.moviemania.home.model.TopMovieModel
@Dao
interface RecentTvShowsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecentTvShow(tv: RecentTvSowsModel)

    @Query("SELECT * FROM recent_tv_shows ORDER BY id ASC")
    fun getRecentTvShows() : LiveData<List<RecentTvSowsModel>>

    @Query("DELETE FROM recent_tv_shows WHERE id=:id")
    suspend fun deleteRecentTvShow(id: Int)

    @Query("DELETE FROM recent_tv_shows")
    suspend fun deleteAllRecentTvShows()
}