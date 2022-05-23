package com.example.moviemania.utils

import android.content.Context
import android.os.Handler
import android.view.View
import androidx.core.view.marginLeft
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.moviemania.R
import com.example.moviemania.home.adapter.HomeRecyclerViewAdapter
import com.example.moviemania.home.adapter.MovieViewPager
import com.example.moviemania.home.model.MovieModel
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import java.util.*
import kotlin.collections.ArrayList

object MovieList {

    fun setUpMovieViewPager(context: Context, adapter: MovieViewPager, viewPager: ViewPager2, dotsIndicator: DotsIndicator, list: ArrayList<MovieModel>) {
            val numOfPages = 3
            val delayBefore: Long = 500
            val periodicDelay: Long = 3000
            var currentPage = 0
            viewPager.adapter = adapter
            dotsIndicator.attachTo(viewPager)
            adapter.setUpData(list)
            viewPager.offscreenPageLimit = 1

            val nextItemVisiblePx = context.resources.getDimension(R.dimen.viewpager_next_item_visible)
            val currentItemHorizontalMarginPx = context.resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
            val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
            val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
                page.translationX = -pageTranslationX * position
                page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
                page.alpha = 0.25f + (1 - kotlin.math.abs(position))
            }
            viewPager.setPageTransformer(pageTransformer)
            val itemDecoration = HorizontalMarginItemDecoration(
                context,
                R.dimen.viewpager_current_item_horizontal_margin
            )
            viewPager.addItemDecoration(itemDecoration)
            val autoScroll = Runnable {
                if (currentPage == numOfPages) {
                    currentPage = 0
                }
                viewPager.setCurrentItem(currentPage++, true)
            }
            val timer = Timer()
            val hanlder = Handler()
            val timerTask = object : TimerTask() {
                override fun run() {
                    hanlder.post(autoScroll)
                }

            }
            timer.schedule(timerTask, delayBefore, periodicDelay)
    }

    fun setUpMovieRecView (context: Context, recyclerView: RecyclerView) {
        val adapter = HomeRecyclerViewAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter.setUpList(MovieModel.list)
    }

}
