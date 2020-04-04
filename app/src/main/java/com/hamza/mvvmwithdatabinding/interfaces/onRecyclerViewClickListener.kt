package com.hamza.mvvmwithdatabinding.interfaces

import android.view.View
import com.hamza.mvvmwithdatabinding.models.Movie

interface onRecyclerViewClickListener{

    fun onItemClick(view: View, movie: Movie)
}