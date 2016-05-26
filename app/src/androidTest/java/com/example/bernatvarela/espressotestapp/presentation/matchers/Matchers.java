package com.example.bernatvarela.espressotestapp.presentation.matchers;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.internal.util.Checks;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class Matchers {
    public static Matcher<Object> withString(final String text) {
        Checks.checkNotNull(text);
        return new BoundedMatcher<Object, String>(String.class) {
            @Override
            public boolean matchesSafely(String item) {
                return text.matches(item);
            }
            @Override
            public void describeTo(Description description) {
                description.appendText("with text: " + text.toString());
                description.toString();
            }
        };
    }
}
