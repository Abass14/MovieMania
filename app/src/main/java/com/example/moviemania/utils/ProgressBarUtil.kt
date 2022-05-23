package com.example.moviemania.utils

import android.content.res.Resources
import android.widget.ProgressBar
import com.example.moviemania.R

object ProgressBarUtil {

    fun setUpProgressBarStyle (progressBar: ProgressBar, resources: Resources) {
        progressBar.indeterminateDrawable.setColorFilter(resources.getColor(R.color.red), android.graphics.PorterDuff.Mode.MULTIPLY)
    }
}