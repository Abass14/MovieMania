package com.example.moviemania.home.ui

import IMAGE_URL
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.moviemania.databinding.FragmentHomeBinding
import com.example.moviemania.home.adapter.HomeViewPagerAdapter
import com.example.moviemania.movies.ui.Movies
import com.example.moviemania.mylist.ui.MyList
import com.example.moviemania.tv.ui.TvShows
import com.example.moviemania.utils.BackGroundTask.doInBack
import com.example.moviemania.utils.BackGroundTask.doWithHandler
import com.example.moviemania.utils.Runnable
import com.example.moviemania.utils.ViewScopeFunctions.loadImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Home : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpTabs()
        loadProfileImage()
    }

    private fun setUpTabs () {
        val adapter = HomeViewPagerAdapter(childFragmentManager)
        binding.apply {
            homeViewPager.adapter = adapter
            homeTabLayout.setupWithViewPager(homeViewPager)
            homeViewPager.offscreenPageLimit
        }
        doWithHandler({
            adapter.addFragments(Movies(), "Movies")
            adapter.addFragments(TvShows(), "TvShows")
            adapter.addFragments(MyList(), "My List")
        }, 500)
    }

    private fun loadProfileImage() {
        lifecycleScope.launch {
            binding.profileImage.loadImage(IMAGE_URL)
        }
    }
}