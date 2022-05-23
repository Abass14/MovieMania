package com.example.moviemania.utils

import android.app.Activity
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

object ViewScopeFunctions {

    fun View.hide () {
        this.visibility = View.GONE
    }
    fun View.show () {
        this.visibility = View.VISIBLE
    }
    fun View.invisible () {
        this.visibility = View.VISIBLE
    }

    fun ImageView.loadImage (imageUrl: String) {
            Glide.with(this).
            load(imageUrl).
            diskCacheStrategy(DiskCacheStrategy.ALL).
            into(this)
    }
}