package com.example.moviemania.mylist.ui

import android.os.Bundle
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
import com.example.moviemania.databinding.FragmentMyListBinding
import com.example.moviemania.home.adapter.TopMoviePagerAdapter
import com.example.moviemania.movies.MoviesViewModel
import com.example.moviemania.utils.*
import com.example.moviemania.utils.NavigationController.checkNavigationDestination
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MyList : Fragment(), ItemClickListener, PlayBtnClickListener {
    private var _binding: FragmentMyListBinding? = null
    private val binding get() = _binding!!

    private val movieViewModel: MoviesViewModel by viewModels()
    private lateinit var moviePagerAdapter: TopMoviePagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviePagerAdapter = TopMoviePagerAdapter(TopMovieComparator())
        setupRecView()
        observeMovieFlow()
//        MovieList.setUpMovieRecViewVertical(requireContext(), binding.myListRecView, MyListRecyclerView(this, this))
        ProgressBarUtil.setUpProgressBarStyle(binding.myListProgressBar, resources)
    }

    private fun setupRecView () {
        binding.myListRecView.apply {
            adapter = moviePagerAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeMovieFlow() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                movieViewModel.topMoviesFlow.collectLatest {
                    launch(Dispatchers.IO) {
                        moviePagerAdapter.submitData(it)
                    }
                }
            }
        }
    }

    override fun itemClick(position: Int) {
        val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        when(checkNavigationDestination(navHostFragment)) {
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
        when(checkNavigationDestination(navHostFragment)) {
            R.id.home2 -> {
                findNavController().navigate(R.id.action_home2_to_videoPlayer)
            }
            else -> {
                findNavController().navigate(R.id.action_myList_to_videoPlayer)
            }
        }
    }

}