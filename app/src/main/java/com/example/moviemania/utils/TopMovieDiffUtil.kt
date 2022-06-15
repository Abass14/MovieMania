package com.example.moviemania.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.moviemania.home.model.LatestMovieModel
import com.example.moviemania.home.model.TopMovieModel

class TopMovieDiffUtil(private val oldList: ArrayList<TopMovieModel>, private val newList: ArrayList<TopMovieModel>) : DiffUtil.Callback() {


    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title === newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val value = oldList[oldItemPosition].id
        val name = oldList[oldItemPosition].original_title
        val value1 = newList[oldItemPosition].id
        val name1 = newList[oldItemPosition].original_title

        return name == name1 && value == value1
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}