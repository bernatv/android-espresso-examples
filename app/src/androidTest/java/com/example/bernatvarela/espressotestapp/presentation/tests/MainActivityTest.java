package com.example.bernatvarela.espressotestapp.presentation.tests;

import org.junit.Test;

public class MainActivityTest extends BaseTest {
    public static final String MERCURY = "Mercury";

    @Test
    public void shouldBeAbleToRunTheTest() {
        espresso.textDisplayed(MERCURY);
    }
}
