package com.hamza.mvvmwithdatabinding.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hamza.mvvmwithdatabinding.R
import com.hamza.mvvmwithdatabinding.adapters.MoviesAdapter
import com.hamza.mvvmwithdatabinding.endpoints.MovieService
import com.hamza.mvvmwithdatabinding.interfaces.IOnRecyclerViewClickListener
import com.hamza.mvvmwithdatabinding.models.Movie
import com.hamza.mvvmwithdatabinding.repos.Repository
import com.hamza.mvvmwithdatabinding.utils.ServiceBuilder
import com.hamza.mvvmwithdatabinding.utils.ViewModelsFactory

import com.hamza.mvvmwithdatabinding.viewmodels.MoviesViewModel
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment : Fragment(),IOnRecyclerViewClickListener {
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
                it.adapter=MoviesAdapter(movies,this@MoviesFragment)
            }
        })
    }

    override fun onItemClick(view: View, movie: Movie) {
     when(view.id){
         R.id.button_book->{
             Toast.makeText(requireContext(),"Button book was clicked",Toast.LENGTH_SHORT).show()
         }
         R.id.layout_like->{
             Toast.makeText(requireContext(),"Like  was clicked",Toast.LENGTH_SHORT).show()

         }
         R.id.imageView->{
             Toast.makeText(requireContext(),"Image  was clicked",Toast.LENGTH_SHORT).show()

         }
         else ->{
             Toast.makeText(requireContext(),"Root  was clicked",Toast.LENGTH_SHORT).show()

         }
     }
    }

}
