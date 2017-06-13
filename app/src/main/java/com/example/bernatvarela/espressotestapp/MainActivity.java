package com.example.bernatvarela.espressotestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public static final String MOVIE = "Movie";
    private ListView mainListView;
    private ArrayAdapter<String> listAdapter;
    private String[] movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainListView = (ListView) findViewById(R.id.mainListView);
        int moviesLimit = 0;

        movies = new String[] { MOVIE };

        ArrayList<String> movieList = new ArrayList<String>();
        movieList.addAll(Arrays.asList(movies));

        listAdapter = new ArrayAdapter<String>(this, R.layout.row, movieList);

        while(moviesLimit != 100) {
            listAdapter.add( MOVIE + ": " + Integer.toString(moviesLimit) );
            moviesLimit = moviesLimit + 1;
        }
        listAdapter.add("find me");

        mainListView.setAdapter(listAdapter);
    }
}
