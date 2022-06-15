package com.example.moviemania.home.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "created_by")
data class CreatedBy(
    val credit_id: String,
    val gender: Int,
    @PrimaryKey
    val id: Int,
    val name: String,
    val profile_path: Any
)