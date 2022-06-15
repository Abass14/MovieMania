package com.example.moviemania.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.moviemania.home.model.BaseMovieModel
import com.example.moviemania.home.model.LatestMovieModel
import com.example.moviemania.home.model.TopMovieModel

class TopMovieComparator : DiffUtil.ItemCallback<TopMovieModel>() {
    override fun areItemsTheSame(oldItem: TopMovieModel, newItem: TopMovieModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TopMovieModel, newItem: TopMovieModel): Boolean {
        val oldId = oldItem.id
        val oldTitle = oldItem.title
        val newId = newItem.id
        val newTitle = newItem.title
        return oldId == newId && oldTitle == newTitle
    }
}