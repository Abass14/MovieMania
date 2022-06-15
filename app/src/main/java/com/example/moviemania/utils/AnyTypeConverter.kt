package com.example.moviemania.utils

import androidx.room.TypeConverter
import org.json.JSONObject

class AnyTypeConverter {
    @TypeConverter
    fun fromSource(genre_id: Any): String {
        return JSONObject().apply {
            put("genre_id", genre_id)
        }.toString()
    }

    @TypeConverter
    fun toSource(source: String): Any {
        val json = JSONObject(source)
        return json.get("genre_id")
    }

}