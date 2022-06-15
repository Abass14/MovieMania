package com.example.moviemania.home.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "production_country")
data class ProductionCountry(
    val iso_3166_1: String,
    @PrimaryKey
    val name: String
)