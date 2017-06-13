package com.example.bernatvarela.espressotestapp.presentation.pages;

import com.example.bernatvarela.espressotestapp.R;

public class MainPage {
    private static final String movie = "Movie";
    protected static final int list = R.id.mainListView;
    protected String stringToBeFound = "Movie: 66";
    protected String partStringToBeFound = ": 70";

    public MainPage() {}

    public int getList() {
        return list;
    }

    public String getPartStringToBeFound() {
        return partStringToBeFound;
    }

    public String getMovie() {
        return movie;
    }

    public String getStringToBeFound() {
        return stringToBeFound;
    }
}
