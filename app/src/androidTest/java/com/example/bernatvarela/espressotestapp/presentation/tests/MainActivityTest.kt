package com.example.bernatvarela.espressotestapp.presentation.tests

import com.example.bernatvarela.espressotestapp.presentation.espresso.EspressoBase
import com.example.bernatvarela.espressotestapp.presentation.pages.MainPage

import org.junit.Test

class MainActivityTest : BaseTest() {
    private val mainPage: MainPage

    init {
        mainPage = MainPage()
    }

    @Test fun shouldBeAbleToRunTheTest() {
        espresso.textDisplayed(mainPage.getMovie())
        espresso.idDisplayed(mainPage.getList())
    }

    @Test fun shouldBeAbleToScrollToMovie() {
        espresso.waitFor(EspressoBase.TIME_TO_WAIT_SHORT)
        espresso.tapOnListElementWithText(mainPage.stringToBeFound, mainPage.getList())
        espresso.waitFor(EspressoBase.TIME_TO_WAIT_SHORT)
        espresso.existsTextElement(mainPage.stringToBeFound)
    }

    @Test fun shouldBeAbleToScrollAndFindAElementWithTextFragment() {
        espresso.waitFor(EspressoBase.TIME_TO_WAIT_SHORT)
        espresso.tapOnListElementThatContainsText(mainPage.partStringToBeFound, mainPage.getList())
        espresso.waitFor(EspressoBase.TIME_TO_WAIT_SHORT)
        espresso.existsTextElement(mainPage.stringToBeFound)
    }
}
