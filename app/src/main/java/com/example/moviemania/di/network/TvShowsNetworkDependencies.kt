package com.example.moviemania.di.network

import com.example.moviemania.di.retrofit.RetrofitInstance
import com.example.moviemania.di.retrofit.RetrofitInstance.Companion.provideRetrofitInstance
import com.example.moviemania.tv.network.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TvShowsNetworkDependencies {

    @Singleton
    @Provides
    fun providesPopularTvApi () : PopularTvApi = provideRetrofitInstance().create(PopularTvApi::class.java)

    @Singleton
    @Provides
    fun providesTvDetailsApi () : TvDetailsApi = provideRetrofitInstance().create(TvDetailsApi::class.java)

    @Singleton
    @Provides
    fun providesTvGenreApi () : TvGenreApi = provideRetrofitInstance().create(TvGenreApi::class.java)

    @Singleton
    @Provides
    fun providesTvOnTheAirApi () : TvOnTheAirApi = provideRetrofitInstance().create(TvOnTheAirApi::class.java)

    @Singleton
    @Provides
    fun providesTvTopRatedApi () : TvTopRatedApi = provideRetrofitInstance().create(TvTopRatedApi::class.java)

    @Singleton
    @Provides
    fun providesTvVideoApi () : TvVideosApi = provideRetrofitInstance().create(TvVideosApi::class.java)
}