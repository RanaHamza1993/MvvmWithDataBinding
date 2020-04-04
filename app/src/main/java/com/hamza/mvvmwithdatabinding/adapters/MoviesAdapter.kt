package com.hamza.mvvmwithdatabinding.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hamza.mvvmwithdatabinding.R
import com.hamza.mvvmwithdatabinding.databinding.RecyclerviewMovieBinding
import com.hamza.mvvmwithdatabinding.interfaces.onRecyclerViewClickListener
import com.hamza.mvvmwithdatabinding.models.Movie

class MoviesAdapter(val movies:List<Movie>,
                    val recyclerViewClickListener: onRecyclerViewClickListener): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding=DataBindingUtil.inflate<RecyclerviewMovieBinding>(LayoutInflater.from(parent.context),
            R.layout.recyclerview_movie,parent,false)
        return MoviesViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.recyclerviewMovieBinding.movie=movies[position]
        holder.recyclerviewMovieBinding.run {
            buttonBook.setOnClickListener {
                recyclerViewClickListener.onItemClick(it,movies[position])
            }
            layoutLike.setOnClickListener {
                recyclerViewClickListener.onItemClick(it,movies[position])

            }
            root.setOnClickListener {
                recyclerViewClickListener.onItemClick(it,movies[position])

            }
        }
    }
    inner class MoviesViewHolder(val recyclerviewMovieBinding: RecyclerviewMovieBinding)
        :RecyclerView.ViewHolder(recyclerviewMovieBinding.root){

    }
}