package com.example.bernatvarela.espressotestapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import java.util.*

class MainActivity : AppCompatActivity() {
    private var mainListView: ListView? = null
    private var listAdapter: ArrayAdapter<String>? = null
    private var movies: Array<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainListView = findViewById(R.id.mainListView) as ListView?
        var moviesLimit = 0

        movies = arrayOf(MOVIE)

        val movieList = ArrayList<String>()
        movieList.addAll(Arrays.asList(*movies!!))

        listAdapter = ArrayAdapter(this, R.layout.row, movieList)

        while (moviesLimit != 100) {
            listAdapter!!.add(MOVIE + ": " + Integer.toString(moviesLimit))
            moviesLimit = moviesLimit + 1
        }
        listAdapter!!.add("find me")

        mainListView!!.adapter = listAdapter
    }

    companion object {
        val MOVIE = "Movie"
    }
}
