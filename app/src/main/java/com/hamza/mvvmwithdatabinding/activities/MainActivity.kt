package com.hamza.mvvmwithdatabinding.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hamza.mvvmwithdatabinding.R
import com.hamza.mvvmwithdatabinding.endpoints.MovieService
import com.hamza.mvvmwithdatabinding.repos.Repository
import com.hamza.mvvmwithdatabinding.utils.ServiceBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val movieRepo=Repository(ServiceBuilder(MovieService::class.java))
//        GlobalScope.launch(Dispatchers.Main) {
//            val list=movieRepo.getMovies()
//            Toast.makeText(this@MainActivity,list.toString(),Toast.LENGTH_SHORT).show()
//        }
    }
}
