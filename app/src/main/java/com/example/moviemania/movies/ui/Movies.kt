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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviemania.R
import com.example.moviemania.databinding.FragmentMoviesBinding
import com.example.moviemania.home.adapter.TopMoviePagerAdapter
import com.example.moviemania.home.adapter.LatestMovieViewPager
import com.example.moviemania.home.model.LatestMovieModel
import com.example.moviemania.movies.MoviesViewModel
import com.example.moviemania.utils.*
import com.example.moviemania.utils.MovieList.movieViewPagerAutoScroll
import com.example.moviemania.utils.MovieList.setUpMovieViewPager
import com.example.moviemania.utils.ProgressBarUtil.setUpProgressBarStyle
import com.example.moviemania.utils.ViewScopeFunctions.hide
import com.example.moviemania.utils.ViewScopeFunctions.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Movies : Fragment(), ItemClickListener, PlayBtnClickListener {
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private val movieViewModel: MoviesViewModel by viewModels()
    private lateinit var moviePagerAdapter: TopMoviePagerAdapter
    private lateinit var movieViewPager: LatestMovieViewPager
    private var latestMovies: ArrayList<LatestMovieModel> = arrayListOf()
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
        moviePagerAdapter = TopMoviePagerAdapter(TopMovieComparator())
        movieViewPager = LatestMovieViewPager(this, this, this)
        setupRecView()
        observeMovieFlow()
        observeLatestMovie()
        setUpProgressBarStyle(binding.movieProgressBar, resources)
        setUpMovieViewPager(
            requireContext(), movieViewPager, binding.movieViewPager, binding.dotsIndicator
        )
//        setUpMovieRecViewHorizontal(requireContext(), binding.recentMoviesRv, HomeRecyclerViewAdapter(this))
//        setUpMovieRecViewHorizontal(requireContext(), binding.topMoviesRv, HomeRecyclerViewAdapter(this))
    }

    private fun observeLatestMovie () {
        movieViewModel.getLatestMovies()
        movieViewModel.latestMoviesLiveData.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    binding.movieProgressBar.show()
                    latestMovies = resource.data as ArrayList<LatestMovieModel>
                    movieViewPager.setUpData(resource.data as ArrayList<LatestMovieModel>)
                    movieViewPagerAutoScroll(resource.data, binding.movieViewPager)
                }
                is Resource.Success -> {
                    latestMovies = resource.data as ArrayList<LatestMovieModel>
                    movieViewPager.setUpData(resource.data as ArrayList<LatestMovieModel>)
                    movieViewPagerAutoScroll(resource.data, binding.movieViewPager)
                    binding.movieProgressBar.hide()
                }
                is Resource.Error -> {
                    binding.movieProgressBar.hide()
                    Log.d("Resource Error", "${resource.error}")
                }
            }
        }
    }

    private fun setupRecView () {
        binding.topMoviesRv.apply {
            adapter = moviePagerAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun observeMovieFlow() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                movieViewModel.topMoviesFlow.collectLatest {
                    launch(Dispatchers.IO) {
                        Log.d("CurrentThread", Thread.currentThread().name)
                        moviePagerAdapter.submitData(it)
                    }
                }
            }
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