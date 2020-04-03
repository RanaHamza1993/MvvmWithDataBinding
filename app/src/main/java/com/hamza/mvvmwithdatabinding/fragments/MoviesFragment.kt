package com.hamza.mvvmwithdatabinding.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.hamza.mvvmwithdatabinding.R
import com.hamza.mvvmwithdatabinding.endpoints.MovieService
import com.hamza.mvvmwithdatabinding.repos.Repository
import com.hamza.mvvmwithdatabinding.utils.ServiceBuilder
import com.hamza.mvvmwithdatabinding.utils.ViewModelsFactory

import com.hamza.mvvmwithdatabinding.viewmodels.MoviesViewModel

class MoviesFragment : Fragment() {
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val factory=ViewModelsFactory(Repository(ServiceBuilder(MovieService::class.java)))
        viewModel = ViewModelProvider(this,factory).get(MoviesViewModel::class.java)
    }

}
