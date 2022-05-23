package com.example.moviemania.home.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.moviemania.R
import com.example.moviemania.databinding.MovieCardLayoutBinding
import com.example.moviemania.home.model.MovieModel
import com.example.moviemania.utils.ViewScopeFunctions.loadImage
import kotlinx.coroutines.launch

class MovieViewPager(val fragment: Fragment) : RecyclerView.Adapter<MovieViewPager.MovieViewHolder>() {
    private var movieList: ArrayList<MovieModel> = arrayListOf()
    class MovieViewHolder(private val binding: MovieCardLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieModel) {
            binding.apply {
//                movieTitle.text = movie.title
                movieImage.loadImage(movie.image)
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewPager.MovieViewHolder {
        val itemBinding = MovieCardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_card_layout, parent, false)
        return  MovieViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MovieViewPager.MovieViewHolder, position: Int) {
        fragment.lifecycleScope.launch {
            holder.bind(movieList[position])
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun setUpData(list: ArrayList<MovieModel>) {
        movieList = list
        notifyDataSetChanged()
    }

}