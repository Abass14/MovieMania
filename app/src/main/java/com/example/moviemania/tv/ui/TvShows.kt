package com.example.moviemania.tv.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviemania.R
import com.example.moviemania.databinding.FragmentTvShowsBinding
import com.example.moviemania.home.adapter.MovieViewPager
import com.example.moviemania.home.model.MovieModel.Companion.list
import com.example.moviemania.utils.MovieList
import com.example.moviemania.utils.ProgressBarUtil

class TvShows : Fragment() {
    private var _binding: FragmentTvShowsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTvShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MovieList.setUpMovieViewPager(requireContext(), MovieViewPager(this), binding.tvShowsViewPager, binding.tvDotsIndicator, list)
        ProgressBarUtil.setUpProgressBarStyle(binding.tvShowsProgressBar, resources)
        MovieList.setUpMovieRecView(requireContext(), binding.recentTvShowsRv)
        MovieList.setUpMovieRecView(requireContext(), binding.topTvShowsRv)
    }
}