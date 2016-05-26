package com.example.bernatvarela.espressotestapp.presentation.tests;

import com.example.bernatvarela.espressotestapp.presentation.pages.MainPage;

import org.junit.Test;

public class MainActivityTest extends BaseTest {
    private MainPage mainPage;

    public MainActivityTest() {
        mainPage = new MainPage();
    }

    @Test
    public void shouldBeAbleToRunTheTest() {
        espresso.textDisplayed(mainPage.getMovie());
        espresso.idDisplayed(mainPage.getList());
    }
}
