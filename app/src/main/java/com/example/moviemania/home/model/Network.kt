package com.example.moviemania.home.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "network")
data class Network(
    @PrimaryKey
    val id: Int,
    val logo_path: String,
    val name: String,
    val origin_country: String
)