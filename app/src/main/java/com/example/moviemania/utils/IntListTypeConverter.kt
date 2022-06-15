package com.example.moviemania.utils

import androidx.room.TypeConverter
import com.example.moviemania.home.model.LatestMovieModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.lang.reflect.Type
import java.util.*

class IntListTypeConverter {
    @TypeConverter
    fun getIntList(list: String): List<Int> {
        return Gson().fromJson(
            list,
            object : TypeToken<List<Int>>() {}.type
        )
    }

    @TypeConverter
    fun listServerToString(someObjects: List<Int?>?): String? {
        val gson = Gson()
        return gson.toJson(someObjects)
    }

}