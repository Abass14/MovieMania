package com.example.moviemania.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

object CoroutineHelper {
    suspend fun Fragment.repeatLifecycle (task: () -> Unit) {
        val that = this
        this.viewLifecycleOwner.lifecycleScope.launch {
            this@repeatLifecycle.viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                task()
            }
        }
    }
}