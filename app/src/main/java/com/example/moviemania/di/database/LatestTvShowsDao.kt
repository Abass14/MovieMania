package com.example.moviemania.di.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviemania.home.model.RecentTvSowsModel
import com.example.moviemania.home.model.LatestTvShowModel

@Dao
interface LatestTvShowsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLatestTvShow(tv: LatestTvShowModel)

    @Query("SELECT * FROM latest_tv_shows ORDER BY id ASC")
    fun getLatestTvShows() : LiveData<List<LatestTvShowModel>>

    @Query("DELETE FROM latest_tv_shows WHERE id=:id")
    suspend fun deleteLatestTvShow(id: Int)

    @Query("DELETE FROM latest_tv_shows")
    suspend fun deleteAllLatestTvShows()
}