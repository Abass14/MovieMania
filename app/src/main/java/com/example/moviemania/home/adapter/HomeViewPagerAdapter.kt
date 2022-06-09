package com.example.moviemania.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.moviemania.movies.ui.Movies
import com.example.moviemania.mylist.ui.MyList
import com.example.moviemania.tv.ui.TvShows

class HomeViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val fragmentList: ArrayList<Fragment> = arrayListOf(
        Movies(), TvShows(), MyList()
    )

//    fun addFragments (fragment: Fragment, title: String) {
//        fragmentList.add(fragment)
//        fragmentTitleList.add(title)
//        notifyDataSetChanged()
//    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }



}
