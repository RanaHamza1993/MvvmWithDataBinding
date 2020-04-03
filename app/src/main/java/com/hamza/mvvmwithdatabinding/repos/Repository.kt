package com.hamza.mvvmwithdatabinding.repos

import android.content.Context
import com.hamza.mvvmwithdatabinding.endpoints.MovieService
import com.hamza.mvvmwithdatabinding.models.Movie
import com.hamza.mvvmwithdatabinding.utils.SafeApiRequest

class Repository(private val movieService:MovieService):SafeApiRequest() {

    companion object {
        @Volatile
        private var INSTANCE: Repository? = null

        fun getInstance(movieService: MovieService) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Repository(movieService).also {
                    INSTANCE = it
                }
            }
    }

   suspend fun getMovies():List<Movie>{
        return apiRequest{movieService.getMovies()}
    }
}