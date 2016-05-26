package com.example.bernatvarela.espressotestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView mainListView;
    private ArrayAdapter<String> listAdapter;
    private String[] planets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainListView = (ListView) findViewById( R.id.mainListView );
        int planetsLimit = 0;

        planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};

        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll(Arrays.asList(planets));

        listAdapter = new ArrayAdapter<String>(this, R.layout.row, planetList);

        while(planetsLimit != 100) {
            listAdapter.add( "Planet" + ": " + planetsLimit );
            planetsLimit = planetsLimit + 1;
        }
        mainListView.setAdapter(listAdapter);
    }
}
