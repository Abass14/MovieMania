package com.example.moviemania.mylist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.moviemania.R
import com.example.moviemania.databinding.FragmentMyListBinding
import com.example.moviemania.mylist.adapter.MyListRecyclerView
import com.example.moviemania.utils.ItemClickListener
import com.example.moviemania.utils.MovieList
import com.example.moviemania.utils.NavigationController.checkNavigationDestination
import com.example.moviemania.utils.PlayBtnClickListener
import com.example.moviemania.utils.ProgressBarUtil

class MyList : Fragment(), ItemClickListener, PlayBtnClickListener {
    private var _binding: FragmentMyListBinding? = null
    private val binding get() = _binding!!
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
        MovieList.setUpMovieRecViewVertical(requireContext(), binding.myListRecView, MyListRecyclerView(this, this))
        ProgressBarUtil.setUpProgressBarStyle(binding.myListProgressBar, resources)
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