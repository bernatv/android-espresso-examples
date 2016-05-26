package com.example.bernatvarela.espressotestapp.presentation.tests;

import android.support.test.rule.ActivityTestRule;

import com.example.bernatvarela.espressotestapp.MainActivity;
import com.example.bernatvarela.espressotestapp.presentation.espresso.EspressoBase;

import org.junit.Rule;

public class BaseTest {
    protected EspressoBase espresso;

    public BaseTest() {
        espresso = EspressoBase.getInstance();
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);
}
