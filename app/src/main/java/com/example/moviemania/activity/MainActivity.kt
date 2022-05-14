package com.example.moviemania.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moviemania.R
import com.example.moviemania.databinding.ActivityMainBinding
import com.example.moviemania.utils.ViewScopeFunctions.hide
import com.example.moviemania.utils.ViewScopeFunctions.show

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.findNavController()
        binding.bottomNavigationView.setupWithNavController(navController)
//        setSupportActionBar(binding.topAppBar)
//        binding.topAppBar.setOnMenuItemClickListener {
//            it.onNavDestinationSelected(navController)
//        }

        navController.addOnDestinationChangedListener { controller, destination, _ ->
            when(destination.id){
                R.id.home2 -> {
                    showBottomNav()
//                    binding.topAppBar.subtitle = "Home"
                }
                R.id.search -> {
                    showBottomNav()
//                    binding.topAppBar.subtitle = "Archive"
                }
                R.id.myList -> {
                    showBottomNav()
//                    binding.topAppBar.subtitle = "Reminder"
                }
                else -> hideBottomNav()
            }
        }

    }

    private fun showBottomNav() {
        binding.bottomNavigationView.show()
    }

    private fun hideBottomNav() {
        binding.bottomNavigationView.hide()
    }

}