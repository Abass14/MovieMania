package com.example.moviemania.movies

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.moviemania.home.model.LatestMovieModel
import com.example.moviemania.movies.repo.TopMoviePagingSource
import com.example.moviemania.movies.repo.MoviesRepoInterface
import com.example.moviemania.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesRepoInterface: MoviesRepoInterface
) : ViewModel() {
    val topMoviesFlow = Pager(
        PagingConfig(pageSize = 20)
    ) {
        TopMoviePagingSource(moviesRepoInterface)
    }.flow.flowOn(Dispatchers.IO).cachedIn(viewModelScope)

    private val _latestMoviesLiveData: MutableLiveData<Resource<List<LatestMovieModel>>> = MutableLiveData()
    val latestMoviesLiveData: LiveData<Resource<List<LatestMovieModel>>> = _latestMoviesLiveData

    fun getLatestMovies () {
        viewModelScope.launch(Dispatchers.IO) {
            val response = moviesRepoInterface.getLatestMovies(1)
            response.collectLatest {
                _latestMoviesLiveData.postValue(it)
            }
        }
    }
}