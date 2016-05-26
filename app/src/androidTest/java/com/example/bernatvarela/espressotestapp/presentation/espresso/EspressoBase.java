package com.example.bernatvarela.espressotestapp.presentation.espresso;


import android.os.SystemClock;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.action.ViewActions;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.not;

public class EspressoBase {
    public int SECONDS_TO_WAIT = 8;
    public int TIMEOUT_TIME = SECONDS_TO_WAIT * 1000;
    public static final int TIME_TO_WAIT_LONG = 4;
    public static final int TIME_TO_WAIT_SHORT = 2;
    private static EspressoBase instance = null;
    public static final String DUE_SOON = "Due soon";

    public EspressoBase() {
    }

    public static EspressoBase getInstance() {
        if(instance == null) {
            instance = new EspressoBase();
        }
        return instance;
    }

    public void idHasFocus(int id) {
        onView(allOf(withId(id), hasFocus()))
                .check(matches(isDisplayed()));
    }

    public void tapOn(int id) {
        tooSmallWaitForId(id);
        onView(withId(id))
                .check(matches(isDisplayed()))
                .perform(click());
    }

    public void tapTextElement(String id) {
        tooSmallWaitForText(id);
        onView(withText(id))
                .check(matches(isDisplayed()))
                .perform(click());
    }

    public void checkIdWithText(int id, String text) {
        onView(withId(id))
                .check(matches(withText(text)));
    }

    public void idDisplayed(int id) {
        tooSmallWaitForId(id);
        onView(withId(id))
                .check(matches(isDisplayed()));
    }

    public void idNotDisplayed(int id) {
        onView(withId(id))
                .check(doesNotExist());
    }

    public void idNotFocused(int id) {
        tooSmallWaitForId(id);
        onView(allOf(withId(id), not(hasFocus())))
                .check(matches(isDisplayed()));
    }

    public void idDisplayedWithText(int id, String text) {
        tooSmallWaitForId(id);
        onView(allOf(withId(id), withText(text)))
                .check(matches(isDisplayed()));
    }

    public void idDisplayedWithHintText(int id, String text) {
        tooSmallWaitForId(id);
        onView(allOf(withId(id), withHint(text)))
                .check(matches(isDisplayed()));
    }

    public void typeOn(int id, String text) {
        tooSmallWaitForId(id);
        onView(withId(id))
                .check(matches(isDisplayed()))
                .perform(typeText(text), closeSoftKeyboard());
    }

    public void typeOnAndSave(int id, String text) {
        tooSmallWaitForId(id);
        onView(withId(id))
                .check(matches(isDisplayed()))
                .perform(typeText(text), ViewActions.pressImeActionButton());
    }

    public void textDisplayed(String text) {
        tooSmallWaitForText(text);
        onView(withText(text))
                .check(matches(isDisplayed()));
    }

    public void textIsNotDisplayed(String text) {
        onView(withText(text))
                .check(doesNotExist());
    }

    public void swipeLeftById(int id) {
        tooSmallWaitForId(id);
        onView(withId(id))
                .check(matches(isDisplayed()))
                .perform(swipeLeft());
    }

    public void swipeDownById(int id) {
        tooSmallWaitForId(id);
        onView((withId(id)))
                .check(matches(isDisplayed()))
                .perform(swipeDown());
    }

    public void swipeDownMyTasksScreenById(int id) {
        onView(allOf(withId(id), hasDescendant(allOf(withText(DUE_SOON)))))
                .check(matches(isDisplayed()))
                .perform(swipeDown());
    }

    public void swipeUpById(int id) {
        tooSmallWaitForId(id);
        onView((withId(id)))
                .check(matches(isDisplayed()))
                .perform(swipeUp());
    }

    public void tapDialog(int id) {
        tooSmallWaitForId(id);
        onView(withText(id)).inRoot(isDialog()).perform(click());
    }

    public void tapOnListElementByPosition(int position, int id) {
        tooSmallWaitForId(id);
        onData(anything())
                .inAdapterView(withId(id))
                .atPosition(position)
                .perform(click());
    }

    public void tooSmallWaitForText(String text) {
        long startTime = System.currentTimeMillis();
        while( !existsTextElement(text)
                && (System.currentTimeMillis()-startTime)< TIMEOUT_TIME);
    }

    public void tooSmallWaitForId(int id) {
        long startTime = System.currentTimeMillis();
        while( !existsId(id)
                && (System.currentTimeMillis()-startTime)< TIMEOUT_TIME);
    }

    public void tooSmallWaitForId(int id, int time) {
        long startTime = System.currentTimeMillis();
        while( !existsId(id)
                && (System.currentTimeMillis()-startTime)< time * 1000) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }

    public boolean existsId(int id) {
        boolean result = true;
        try {
            onView(withId(id)).check(matches(isDisplayed()));
        } catch (NoMatchingViewException e) {
            result = false;
        }
        return result;
    }

    public boolean existsTextElement(String text) {
        boolean result = true;
        try {
            onView(withText(text)).check(matches(isDisplayed()));
        } catch (NoMatchingViewException e) {
            result = false;
        }
        return result;
    }

    public void waitFor(int time) {
        int timeWithMiliSeconds = time * 1000;
        SystemClock.sleep(timeWithMiliSeconds);
    }

    public void tapLogoutDialog(int id) {
        onView(withText(id)).inRoot(isDialog()).perform(click());
    }
}