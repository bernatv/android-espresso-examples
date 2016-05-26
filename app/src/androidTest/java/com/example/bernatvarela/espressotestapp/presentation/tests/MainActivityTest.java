package com.example.bernatvarela.espressotestapp.presentation.tests;

import org.junit.Test;

public class MainActivityTest extends BaseTest {
    public static final String MOVIE = "Movie";

    @Test
    public void shouldBeAbleToRunTheTest() {
        espresso.textDisplayed(MOVIE);
    }
}
