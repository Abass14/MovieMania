package com.example.moviemania.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moviemania.movies.ui.Movies
import com.example.moviemania.mylist.ui.MyList
import com.example.moviemania.tv.ui.TvShows

class HomeViewPagerAdapter(supportFragmentManager: FragmentManager) : FragmentPagerAdapter(
    supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    private val fragmentList: ArrayList<Fragment> = arrayListOf()
    private val fragmentTitleList: ArrayList<String> = arrayListOf()
    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }

    fun addFragments (fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
        notifyDataSetChanged()
    }


}
