package com.example.moviemania.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.moviemania.home.model.MovieModel

class MovieComparator : DiffUtil.ItemCallback<MovieModel>() {
    override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return oldItem == newItem
    }
}