package com.example.moviemania.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.moviemania.home.model.MovieModel
import com.example.moviemania.movies.repo.MoviePagingSource
import com.example.moviemania.movies.repo.MoviesRepoInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesRepoInterface: MoviesRepoInterface
) : ViewModel() {
    val flow = Pager(
        PagingConfig(pageSize = 20)
    ) {
        MoviePagingSource(moviesRepoInterface)
    }.flow.flowOn(Dispatchers.IO).cachedIn(viewModelScope)
}