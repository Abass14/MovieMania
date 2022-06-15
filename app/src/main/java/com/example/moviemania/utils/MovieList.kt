package com.example.moviemania.utils

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.moviemania.R
import com.example.moviemania.home.adapter.TopMovieRecyclerViewAdapter
import com.example.moviemania.home.adapter.LatestMovieViewPager
import com.example.moviemania.home.model.LatestMovieModel
import com.example.moviemania.mylist.adapter.MyListRecyclerView
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import java.util.*
import kotlin.collections.ArrayList

object MovieList {

    fun setUpMovieViewPager(context: Context, adapter: LatestMovieViewPager, viewPager: ViewPager2, dotsIndicator: DotsIndicator, list: ArrayList<LatestMovieModel> = ArrayList(20)) {
            val numOfPages = list.size
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
    }

    fun movieViewPagerAutoScroll (list: ArrayList<LatestMovieModel>, viewPager: ViewPager2) {
        val numOfPages = list.size
        val delayBefore: Long = 500
        val periodicDelay: Long = 3000
        var currentPage = 0
        val autoScroll = Runnable {
            Log.d("AutoScroll", "$currentPage")
            Log.d("AutoScroll Total", "$numOfPages")
            if (currentPage == numOfPages) {
                currentPage = 0
            }
            viewPager.setCurrentItem(currentPage++, true)
        }
        val timer = Timer()
        val hanlder = Handler(Looper.getMainLooper())
        val timerTask = object : TimerTask() {
            override fun run() {
                hanlder.post(autoScroll)
            }

        }
        timer.schedule(timerTask, delayBefore, periodicDelay)
    }

    fun setUpMovieRecViewHorizontal (context: Context, recyclerView: RecyclerView, adapter: TopMovieRecyclerViewAdapter) {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        adapter.setUpList(MovieModel.list)
    }

    fun setUpMovieRecViewVertical (context: Context, recyclerView: RecyclerView, adapter: MyListRecyclerView) {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
//        adapter.setUpData(MovieModel.list)
    }

}
