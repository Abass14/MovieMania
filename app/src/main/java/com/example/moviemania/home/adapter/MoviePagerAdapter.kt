package com.example.moviemania.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviemania.databinding.MovieCardBinding
import com.example.moviemania.home.model.MovieModel
import com.example.moviemania.utils.AppDiffUtil
import com.example.moviemania.utils.ViewScopeFunctions.loadImage

class MoviePagerAdapter(
    diffUtilCallBack: DiffUtil.ItemCallback<MovieModel>
) : PagingDataAdapter<MovieModel, MoviePagerAdapter.MovieViewHolder>(diffUtilCallBack){
    class MovieViewHolder(val binding: MovieCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(views: MovieModel){
            if (views.backdrop_path != null){
                binding.movieCardImage.let {
                    it.loadImage("https://image.tmdb.org/t/p/w185${views.poster_path}")
                }
            }
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemBinding = MovieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemBinding)
    }

}