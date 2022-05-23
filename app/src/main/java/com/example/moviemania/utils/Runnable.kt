package com.example.moviemania.utils

import android.app.Activity
import android.util.Log
import java.lang.Runnable

class Runnable(val task: () -> Unit) : Runnable {
    override fun run() {
        try {
            task()
        } catch (e: Exception){
            Log.d("Background Work Error", "run: $e")
        }
    }
}