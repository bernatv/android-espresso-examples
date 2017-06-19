package com.example.bernatvarela.espressotestapp.presentation.tests

import android.support.test.rule.ActivityTestRule

import com.example.bernatvarela.espressotestapp.MainActivity
import com.example.bernatvarela.espressotestapp.presentation.espresso.EspressoBase

import org.junit.Rule

open class BaseTest {
    protected var espresso: EspressoBase

    init {
        espresso = EspressoBase()
    }

    @JvmField
    @Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
}
