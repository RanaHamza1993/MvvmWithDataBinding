package com.hamza.mvvmwithdatabinding.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hamza.mvvmwithdatabinding.models.Movie
import com.hamza.mvvmwithdatabinding.repos.Repository
import com.hamza.mvvmwithdatabinding.utils.Coroutines
import kotlinx.coroutines.Job

class MoviesViewModel(
    private val repo:Repository
) : ViewModel() {
    lateinit var job: Job
    private val _movies=MutableLiveData<List<Movie>>()
    val movies:LiveData<List<Movie>>
    get()=_movies

    fun getMoviesList():LiveData<List<Movie>>{
        job=Coroutines.ioThenMain(
            {repo.getMovies()},
            {
                _movies.value=it
            })
        return movies
    }

    override fun onCleared() {

        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}
