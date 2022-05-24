package com.example.moviemania.mylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviemania.databinding.MovieListLayoutBinding
import com.example.moviemania.home.model.MovieModel
import com.example.moviemania.utils.AppDiffUtil
import com.example.moviemania.utils.ItemClickListener
import com.example.moviemania.utils.PlayBtnClickListener
import com.example.moviemania.utils.ViewScopeFunctions.loadImage

class MyListRecyclerView(
    private val itemClickListener: ItemClickListener,
    private val playBtnClickListener: PlayBtnClickListener
) : RecyclerView.Adapter<MyListRecyclerView.MyListViewHolder>() {
    private val myList: ArrayList<MovieModel> = arrayListOf()
    class MyListViewHolder(private val binding: MovieListLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        val viewBinding = binding
        fun bind(movie: MovieModel) {
            binding.apply {
                movieListTitleValue.text = movie.title
                movieListGenreValue.text = movie.genre
                movieListDescriptionValue.text = movie.description
                movieListIv.loadImage(movie.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListViewHolder {
        val inflater = MovieListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyListViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        holder.bind(myList[position])
        holder.viewBinding.movieListCard.setOnClickListener {
            itemClickListener.itemClick(position)
        }
        holder.viewBinding.moviesListPlayBtn.setOnClickListener {
            playBtnClickListener.playClick(position)
        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setUpData(newList: ArrayList<MovieModel>) {
        val diffUtilCallback = AppDiffUtil(myList, newList)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtilCallback)
        myList.clear()
        myList.addAll(newList)
        diffUtilResult.dispatchUpdatesTo(this)
    }
}