package com.example.moviemania.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviemania.R
import com.example.moviemania.databinding.MovieCardLayoutBinding
import com.example.moviemania.home.model.LatestMovieModel
import com.example.moviemania.utils.LatestMovieDiffUtil
import com.example.moviemania.utils.ItemClickListener
import com.example.moviemania.utils.PlayBtnClickListener
import com.example.moviemania.utils.ViewScopeFunctions.loadImage
import kotlinx.coroutines.launch

class LatestMovieViewPager(
    val fragment: Fragment,
    private val itemClick: ItemClickListener,
    private val playClicked: PlayBtnClickListener
) : RecyclerView.Adapter<LatestMovieViewPager.MovieViewHolder>() {
    private var movieList: ArrayList<LatestMovieModel> = arrayListOf()
    class MovieViewHolder(private val binding: MovieCardLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        val viewBinding = binding
        fun bind(movie: LatestMovieModel) {
            binding.apply {
                movie.poster_path.let { movieImage.loadImage("https://image.tmdb.org/t/p/w185$it") }
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LatestMovieViewPager.MovieViewHolder {
        val itemBinding = MovieCardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_card_layout, parent, false)
        return  MovieViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: LatestMovieViewPager.MovieViewHolder, position: Int) {
        fragment.lifecycleScope.launch {
            holder.bind(movieList[position])
        }
        holder.viewBinding.movieCard.setOnClickListener {
            itemClick.itemClick(position)
        }
        holder.viewBinding.latestMoviePlayBtn.setOnClickListener {
            playClicked.playClick(position)
        }

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun setUpData(list: ArrayList<LatestMovieModel>) {
        val diffUtilCallback = LatestMovieDiffUtil(movieList, list)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtilCallback)
        movieList.clear()
        movieList.addAll(list)
        diffUtilResult.dispatchUpdatesTo(this)
    }

}