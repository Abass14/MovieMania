package com.example.moviemania.utils

import android.view.View

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
}