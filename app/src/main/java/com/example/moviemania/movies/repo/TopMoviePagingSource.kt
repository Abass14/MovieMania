package com.example.moviemania.movies.repo

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.moviemania.home.model.BaseMovieModel
import com.example.moviemania.home.model.LatestMovieModel
import com.example.moviemania.home.model.TopMovieModel
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class TopMoviePagingSource @Inject constructor(
    private val moviesRepoInterface: MoviesRepoInterface
) : PagingSource<Int, TopMovieModel>(){
    override fun getRefreshKey(state: PagingState<Int, TopMovieModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TopMovieModel> {
        return try {
            val pageIndex = params.key ?: 1
            val response = moviesRepoInterface.getTopMovies(pageIndex)
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