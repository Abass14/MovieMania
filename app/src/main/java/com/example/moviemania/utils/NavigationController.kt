package com.example.moviemania.utils

import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.moviemania.R

object NavigationController {
    fun checkNavigationDestination(fragment: NavHostFragment): Int {
        val navController = fragment.findNavController()
        return navController.currentDestination?.id!!
    }
}