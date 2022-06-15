package com.example.moviemania.home.ui

import IMAGE_URL
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.moviemania.databinding.FragmentHomeBinding
import com.example.moviemania.home.adapter.HomeViewPagerAdapter
import com.example.moviemania.utils.ViewScopeFunctions.loadImage
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
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
        val homeViewPagerAdapter = HomeViewPagerAdapter(requireActivity())
        binding.homeViewPager.apply {
            adapter = homeViewPagerAdapter
            viewLifecycleOwner.lifecycleScope.launch {
                TabLayoutMediator(binding.homeTabLayout, binding.homeViewPager) { tab, position ->
                    when (position) {
                        0 -> tab.text = "Movies"
                        1 -> tab.text = "Tv Shows"
                        2 -> tab.text = "My List"
                    }
                }.attach()
            }
        }
    }

    private fun loadProfileImage() {
        lifecycleScope.launch {
            binding.profileImage.loadImage(IMAGE_URL)
        }
    }
}