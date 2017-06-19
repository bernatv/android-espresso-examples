package com.example.bernatvarela.espressotestapp.presentation.pages

import com.example.bernatvarela.espressotestapp.R

class MainPage {
    val stringToBeFound = "Movie: 66"
    val partStringToBeFound = "Movie: 70"

    fun getList(): Int {
        return list
    }

    fun getMovie(): String {
        return movie
    }

    companion object {
        private val movie = "Movie"
        private val list = R.id.mainListView
    }
}
