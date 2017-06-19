package com.example.bernatvarela.espressotestapp.presentation.matchers

import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.internal.util.Checks

import org.hamcrest.Description
import org.hamcrest.Matcher

object Matchers {
    fun withString(text: String): Matcher<Any> {
        Checks.checkNotNull(text)
        return object : BoundedMatcher<Any, String>(String::class.java) {
            public override fun matchesSafely(item: String): Boolean {
                return text.matches(item.toRegex())
            }

            override fun describeTo(description: Description) {
                description.appendText("with text: " + text.toString())
                description.toString()
            }
        }
    }

    fun containsString(text: String): Matcher<Any> {
        Checks.checkNotNull(text)
        return object : BoundedMatcher<Any, String>(String::class.java) {
            public override fun matchesSafely(item: String): Boolean {
                return text.contains(text)
            }

            override fun describeTo(description: Description) {
                description.appendText("with text: " + text.toString())
                description.toString()
            }
        }
    }
}
