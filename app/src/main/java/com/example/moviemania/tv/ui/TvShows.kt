package com.example.moviemania.tv.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.moviemania.R
import com.example.moviemania.databinding.FragmentTvShowsBinding
import com.example.moviemania.home.adapter.HomeRecyclerViewAdapter
import com.example.moviemania.home.adapter.MovieViewPager
import com.example.moviemania.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShows : Fragment(), ItemClickListener, PlayBtnClickListener {
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
//        MovieList.setUpMovieViewPager(requireContext(), MovieViewPager(this, this, this), binding.tvShowsViewPager, binding.tvDotsIndicator, list)
        ProgressBarUtil.setUpProgressBarStyle(binding.tvShowsProgressBar, resources)
        MovieList.setUpMovieRecViewHorizontal(requireContext(), binding.recentTvShowsRv, HomeRecyclerViewAdapter(this))
        MovieList.setUpMovieRecViewHorizontal(requireContext(), binding.topTvShowsRv, HomeRecyclerViewAdapter(this))
    }

    override fun itemClick(position: Int) {
        val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        when(NavigationController.checkNavigationDestination(navHostFragment)) {
            R.id.home2 -> {
                findNavController().navigate(R.id.action_home2_to_details)
            }
            else -> {
                findNavController().navigate(R.id.action_myList_to_details)
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
                findNavController().navigate(R.id.action_myList_to_videoPlayer)
            }
        }
    }
}