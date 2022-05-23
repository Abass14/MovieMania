package com.example.moviemania.movies.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviemania.R
import com.example.moviemania.databinding.FragmentMoviesBinding
import com.example.moviemania.databinding.MovieCardLayoutBinding
import com.example.moviemania.home.adapter.MovieViewPager
import com.example.moviemania.home.model.MovieModel.Companion.list
import com.example.moviemania.utils.MovieList

class Movies : Fragment() {
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MovieList.setUpMovieViewPager(requireContext(), MovieViewPager(this), binding.movieViewPager, binding.dotsIndicator)
    }

}