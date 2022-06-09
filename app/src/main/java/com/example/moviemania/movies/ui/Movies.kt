package com.example.moviemania.movies.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.paging.filter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviemania.R
import com.example.moviemania.databinding.FragmentMoviesBinding
import com.example.moviemania.home.adapter.HomeRecyclerViewAdapter
import com.example.moviemania.home.adapter.MoviePagerAdapter
import com.example.moviemania.home.adapter.MovieViewPager
import com.example.moviemania.movies.MoviesViewModel
import com.example.moviemania.utils.*
import com.example.moviemania.utils.BackGroundTask.doWithHandler
import com.example.moviemania.utils.MovieList.setUpMovieRecViewHorizontal
import com.example.moviemania.utils.ProgressBarUtil.setUpProgressBarStyle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Movies : Fragment(), ItemClickListener, PlayBtnClickListener {
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private val movieViewModel: MoviesViewModel by viewModels()
//    private lateinit var moviePagerAdapter: MoviePagerAdapter
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
//        moviePagerAdapter = MoviePagerAdapter(MovieComparator())
//        setupRecView()
//        observeMovieFlow()
//        MovieList.setUpMovieViewPager(requireContext(), MovieViewPager(this, this, this), binding.movieViewPager, binding.dotsIndicator, list)
        setUpProgressBarStyle(binding.movieProgressBar, resources)
//        setUpMovieRecViewHorizontal(requireContext(), binding.recentMoviesRv, HomeRecyclerViewAdapter(this))
//        setUpMovieRecViewHorizontal(requireContext(), binding.topMoviesRv, HomeRecyclerViewAdapter(this))
        binding.seeAllRecentTv.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_details)
        }

    }

//    private fun setupRecView () {
//        binding.recentMoviesRv.apply {
//            adapter = moviePagerAdapter
//            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//        }
//    }

//    private fun observeMovieFlow() {
//        viewLifecycleOwner.lifecycleScope.launch {
//            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
//                Log.d("CurrentThread - Observe", Thread.currentThread().name)
//                movieViewModel.flow.collectLatest {
//                    moviePagerAdapter.submitData(it)
//                }
//            }
//        }
//    }

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