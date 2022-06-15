package com.example.moviemania.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviemania.databinding.MovieCardBinding
import com.example.moviemania.home.model.LatestMovieModel
import com.example.moviemania.home.model.TopMovieModel
import com.example.moviemania.utils.ViewScopeFunctions.loadImage

class TopMoviePagerAdapter(
    diffUtilCallBack: DiffUtil.ItemCallback<TopMovieModel>
) : PagingDataAdapter<TopMovieModel, TopMoviePagerAdapter.MovieViewHolder>(diffUtilCallBack){
    class MovieViewHolder(val binding: MovieCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(views: TopMovieModel){
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