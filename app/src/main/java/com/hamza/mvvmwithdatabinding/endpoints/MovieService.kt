package com.hamza.mvvmwithdatabinding.endpoints

import com.hamza.mvvmwithdatabinding.models.Movie
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

    @GET("movies")
    suspend fun getMovies():Response<List<Movie>>
}