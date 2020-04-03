package com.hamza.mvvmwithdatabinding.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.hamza.mvvmwithdatabinding.repos.Repository
import com.hamza.mvvmwithdatabinding.viewmodels.MoviesViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelsFactory(
    private val repo:Repository
)
    : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(repo) as T
    }
}