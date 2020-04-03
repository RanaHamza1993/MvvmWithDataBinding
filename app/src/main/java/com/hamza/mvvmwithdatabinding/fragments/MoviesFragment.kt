package com.hamza.mvvmwithdatabinding.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hamza.mvvmwithdatabinding.R
import com.hamza.mvvmwithdatabinding.adapters.MoviesAdapter
import com.hamza.mvvmwithdatabinding.endpoints.MovieService
import com.hamza.mvvmwithdatabinding.repos.Repository
import com.hamza.mvvmwithdatabinding.utils.ServiceBuilder
import com.hamza.mvvmwithdatabinding.utils.ViewModelsFactory

import com.hamza.mvvmwithdatabinding.viewmodels.MoviesViewModel
import kotlinx.android.synthetic.main.movies_fragment.*

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
        viewModel.getMoviesList()
        viewModel.movies.observe(viewLifecycleOwner, Observer {movies->
            recycler_view_movies.also {
                it.layoutManager=LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
                it.hasFixedSize()
                it.adapter=MoviesAdapter(movies)
            }
        })
    }

}
