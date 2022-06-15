package com.example.moviemania.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviemania.databinding.MovieCardBinding
import com.example.moviemania.home.model.TopMovieModel
import com.example.moviemania.utils.LatestMovieDiffUtil
import com.example.moviemania.utils.ItemClickListener
import com.example.moviemania.utils.TopMovieDiffUtil

class TopMovieRecyclerViewAdapter(
    private val itemClick: ItemClickListener,
) : RecyclerView.Adapter<TopMovieRecyclerViewAdapter.HomeViewHolder>() {
    private val movieList: ArrayList<TopMovieModel> = arrayListOf()
    class HomeViewHolder (private val binding: MovieCardBinding) : RecyclerView.ViewHolder(binding.root) {
        val viewBinding = binding
        fun bind (movie: TopMovieModel) {
//            binding.movieCardImage.loadImage(movie.image)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopMovieRecyclerViewAdapter.HomeViewHolder {
        val itemBinding = MovieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: TopMovieRecyclerViewAdapter.HomeViewHolder, position: Int) {
        holder.bind(movieList[position])
        holder.viewBinding.movieCardView.setOnClickListener {
            itemClick.itemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun setUpList (newList : ArrayList<TopMovieModel>) {
        val diffCallBack = TopMovieDiffUtil(movieList, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
        movieList.clear()
        movieList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
}