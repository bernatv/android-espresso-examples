package com.example.bernatvarela.espressotestapp.presentation.espresso

import android.os.SystemClock
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.NoMatchingViewException
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.doesNotExist
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.RootMatchers.isDialog
import android.support.test.espresso.matcher.ViewMatchers.*
import android.view.View
import com.example.bernatvarela.espressotestapp.presentation.matchers.Matchers
import org.hamcrest.Matchers.*

class EspressoBase {
    var SECONDS_TO_WAIT = 8
    var TIMEOUT_TIME = SECONDS_TO_WAIT * 1000
    var matchers: Matchers

    init {
        matchers = Matchers
    }

    fun idHasFocus(id: Int) {
        onView(allOf<View>(withId(id), hasFocus()))
                .check(matches(isDisplayed()))
    }

    fun tapOn(id: Int) {
        tooSmallWaitForId(id)
        onView(withId(id))
                .check(matches(isDisplayed()))
                .perform(click())
    }

    fun tapTextElement(id: String) {
        tooSmallWaitForText(id)
        onView(withText(id))
                .check(matches(isDisplayed()))
                .perform(click())
    }

    fun checkIdWithText(id: Int, text: String) {
        onView(withId(id))
                .check(matches(withText(text)))
    }

    fun idDisplayed(id: Int) {
        tooSmallWaitForId(id)
        onView(withId(id))
                .check(matches(isDisplayed()))
    }

    fun idNotDisplayed(id: Int) {
        onView(withId(id))
                .check(doesNotExist())
    }

    fun idNotFocused(id: Int) {
        tooSmallWaitForId(id)
        onView(allOf<View>(withId(id), not<View>(hasFocus())))
                .check(matches(isDisplayed()))
    }

    fun idDisplayedWithText(id: Int, text: String) {
        tooSmallWaitForId(id)
        onView(allOf<View>(withId(id), withText(text)))
                .check(matches(isDisplayed()))
    }

    fun idDisplayedWithHintText(id: Int, text: String) {
        tooSmallWaitForId(id)
        onView(allOf<View>(withId(id), withHint(text)))
                .check(matches(isDisplayed()))
    }

    fun typeOn(id: Int, text: String) {
        tooSmallWaitForId(id)
        onView(withId(id))
                .check(matches(isDisplayed()))
                .perform(typeText(text), closeSoftKeyboard())
    }

    fun typeOnAndSave(id: Int, text: String) {
        tooSmallWaitForId(id)
        onView(withId(id))
                .check(matches(isDisplayed()))
                .perform(typeText(text), ViewActions.pressImeActionButton())
    }

    fun textDisplayed(text: String) {
        tooSmallWaitForText(text)
        onView(withText(text))
                .check(matches(isDisplayed()))
    }

    fun textIsNotDisplayed(text: String) {
        onView(withText(text))
                .check(doesNotExist())
    }

    fun swipeLeftById(id: Int) {
        tooSmallWaitForId(id)
        onView(withId(id))
                .check(matches(isDisplayed()))
                .perform(swipeLeft())
    }

    fun swipeDownById(id: Int) {
        tooSmallWaitForId(id)
        onView(withId(id))
                .check(matches(isDisplayed()))
                .perform(swipeDown())
    }

    fun swipeUpById(id: Int) {
        tooSmallWaitForId(id)
        onView(withId(id))
                .check(matches(isDisplayed()))
                .perform(swipeUp())
    }

    fun tapDialog(id: Int) {
        tooSmallWaitForId(id)
        onView(withText(id)).inRoot(isDialog()).perform(click())
    }

    fun tapOnListElementByPosition(position: Int, id: Int) {
        tooSmallWaitForId(id)
        onData(anything())
                .inAdapterView(withId(id))
                .atPosition(position)
                .perform(click())
    }

    fun tapOnListElementWithText(text: String, id: Int) {
        tooSmallWaitForId(id)
        onData(Matchers.withString(text))
                .inAdapterView(withId(id))
                .perform(click())
    }

    fun tapOnListElementThatContainsText(text: String, id: Int) {
        tooSmallWaitForId(id)
        onData(Matchers.withString("Movie: 70"))
                .inAdapterView(withId(id))
                .check(matches(isDisplayed()))
                .perform(click())

    }

    fun tooSmallWaitForText(text: String) {
        val startTime = System.currentTimeMillis()
        while (!existsTextElement(text) && System.currentTimeMillis() - startTime < TIMEOUT_TIME) {}
    }

    fun tooSmallWaitForId(id: Int) {
        val startTime = System.currentTimeMillis()
        while (!existsId(id) && System.currentTimeMillis() - startTime < TIMEOUT_TIME) {}
    }

    fun tooSmallWaitForId(id: Int, time: Int) {
        val startTime = System.currentTimeMillis()
        while (!existsId(id) && System.currentTimeMillis() - startTime < time * 1000) {
            try {
                Thread.sleep(100)
            } catch (e: InterruptedException) {}
        }
    }

    fun existsId(id: Int): Boolean {
        var result = true
        try {
            onView(withId(id)).check(matches(isDisplayed()))
        } catch (e: NoMatchingViewException) {
            result = false
        }

        return result
    }

    fun existsTextElement(text: String): Boolean {
        var result = true
        try {
            onView(withText(text)).check(matches(isDisplayed()))
        } catch (e: NoMatchingViewException) {
            result = false
        }

        return result
    }

    fun waitFor(time: Int) {
        val timeWithMiliSeconds = time * 1000
        SystemClock.sleep(timeWithMiliSeconds.toLong())
    }

    fun tapLogoutDialog(id: Int) {
        onView(withText(id)).inRoot(isDialog()).perform(click())
    }

    companion object {
        val TIME_TO_WAIT_LONG = 4
        val TIME_TO_WAIT_SHORT = 2
        var instance: EspressoBase? = null
    }
}