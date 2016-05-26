package com.example.bernatvarela.espressotestapp.presentation.tests;

import com.example.bernatvarela.espressotestapp.presentation.espresso.EspressoBase;
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

    @Test
    public void shouldBeAbleToScrollToMovie() {
        espresso.waitFor(EspressoBase.TIME_TO_WAIT_SHORT);
        espresso.tapOnListElementWithText(mainPage.getStringToBeFound(), mainPage.getList());
        espresso.waitFor(EspressoBase.TIME_TO_WAIT_SHORT);
        espresso.existsTextElement(mainPage.getStringToBeFound());
    }
}
