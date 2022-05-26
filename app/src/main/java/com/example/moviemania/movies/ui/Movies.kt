package com.example.moviemania.movies.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.moviemania.R
import com.example.moviemania.databinding.FragmentMoviesBinding
import com.example.moviemania.home.adapter.HomeRecyclerViewAdapter
import com.example.moviemania.home.adapter.MovieViewPager
import com.example.moviemania.utils.ItemClickListener
import com.example.moviemania.utils.MovieList
import com.example.moviemania.utils.MovieList.setUpMovieRecViewHorizontal
import com.example.moviemania.utils.NavigationController
import com.example.moviemania.utils.PlayBtnClickListener
import com.example.moviemania.utils.ProgressBarUtil.setUpProgressBarStyle

class Movies : Fragment(), ItemClickListener, PlayBtnClickListener {
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
//        MovieList.setUpMovieViewPager(requireContext(), MovieViewPager(this, this, this), binding.movieViewPager, binding.dotsIndicator, list)
        setUpProgressBarStyle(binding.movieProgressBar, resources)
        setUpMovieRecViewHorizontal(requireContext(), binding.recentMoviesRv, HomeRecyclerViewAdapter(this))
        setUpMovieRecViewHorizontal(requireContext(), binding.topMoviesRv, HomeRecyclerViewAdapter(this))
        binding.seeAllRecentTv.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_details)
        }

    }

    override fun itemClick(position: Int) {
        val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        when(NavigationController.checkNavigationDestination(navHostFragment)) {
            R.id.home2 -> {
                findNavController().navigate(R.id.action_home2_to_details)
            }
            else -> {
                findNavController().navigate(R.id.action_movies_to_details)
            }
        }
    }

    override fun playClick(position: Int) {
        val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        when(NavigationController.checkNavigationDestination(navHostFragment)) {
            R.id.home2 -> {
                findNavController().navigate(R.id.action_home2_to_videoPlayer)
            }
            else -> {
                findNavController().navigate(R.id.action_movies_to_videoPlayer)
            }
        }
    }


}