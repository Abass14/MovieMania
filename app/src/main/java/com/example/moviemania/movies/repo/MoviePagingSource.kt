package com.example.moviemania.movies.repo

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.moviemania.home.model.MovieModel
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MoviePagingSource @Inject constructor(
    private val moviesRepoInterface: MoviesRepoInterface
) : PagingSource<Int, MovieModel>(){
    override fun getRefreshKey(state: PagingState<Int, MovieModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieModel> {
        return try {
            val pageIndex = params.key ?: 1
            val response = moviesRepoInterface.getLatestMovies(pageIndex)
            val nextPage = if (response.results.isEmpty()) null else pageIndex + 1
            LoadResult.Page(
                data = response.results,
                prevKey = if (pageIndex == 1) null else pageIndex,
                nextKey = nextPage
            )
        }catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}