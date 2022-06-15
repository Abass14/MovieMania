package com.example.moviemania.di.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moviemania.home.model.*
import com.example.moviemania.utils.AnyTypeConverter
import com.example.moviemania.utils.IntListTypeConverter
import com.example.moviemania.utils.StringListTypeConverter

@Database(entities = [
    LatestMovieModel::class,
    CreatedBy::class,
    LastEpisodeToAir::class,
    Network::class,
    ProductionCompany::class,
    ProductionCountry::class,
    Season::class,
    MyListModel::class,
    SpokenLanguage::class,
    LatestTvShowModel::class,
    RecentMovieModel::class,
    RecentTvSowsModel::class,
    TopMovieModel::class,
    TopTvShowsModel::class
], version = 1, exportSchema = false)
@TypeConverters(IntListTypeConverter::class, StringListTypeConverter::class, AnyTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getLatestMoviesDao () : LatestMovieDao
    abstract fun getLatestTvShowsDao () : LatestTvShowsDao
    abstract fun getMyListDao () : MyListDao
    abstract fun getRecentMoviesDao () : RecentMoviesDao
    abstract fun getRecentTvShowsDao () : RecentTvShowsDao
    abstract fun getTopMoviesDao () : TopMoviesDao
    abstract fun getTopTvShowsDao () : TopTvShowsDao

    companion object{
        @Volatile
        private var DB_INSTANCE: AppDatabase? = null

        fun getDBInstance(context: Context) : AppDatabase {

            if (DB_INSTANCE == null){
                DB_INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "App_DB"
                ).build()
            }
            return DB_INSTANCE!!
        }
    }
}