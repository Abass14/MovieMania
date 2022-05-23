package com.example.moviemania.utils

import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object BackGroundTask {
    val handler = Handler(Looper.getMainLooper())
    suspend fun doInBack(task: () -> Unit) {
        withContext(Dispatchers.Main){
            task()
        }
    }

    fun doWithHandler(task: () -> Unit, delay: Long) {
        handler.postDelayed({
            task()
        }, delay)
    }
}