package com.hamza.mvvmwithdatabinding.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hamza.mvvmwithdatabinding.models.Movie
import com.hamza.mvvmwithdatabinding.repos.Repository

class MoviesViewModel(
    private val repo:Repository
) : ViewModel() {

    private val _movies=MutableLiveData<List<Movie>>()
    val movies:LiveData<List<Movie>>
    get()=_movies
}
