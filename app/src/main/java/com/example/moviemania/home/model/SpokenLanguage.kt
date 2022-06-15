package com.example.moviemania.home.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spoken_language")
data class SpokenLanguage(
    val english_name: String,
    val iso_639_1: String,
    @PrimaryKey
    val name: String
)