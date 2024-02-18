package com.example.notesapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityUITest {

    @get:Rule
    val activity : ActivityTestRule<*> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun app_opened_rv_shown(){
        onView(withId(R.id.rv))
            .check(matches(isDisplayed()))
    }

    @Test
    fun app_opened_fab_shown(){
        onView(withId(R.id.fab))
            .check(matches(isDisplayed()))
    }

    @Test
    fun fab_clicked_dialog_open(){
        onView(withId(R.id.fab))
            .perform(click())

        onView(withId(R.id.layout_dialog))
            .check(matches(isDisplayed()))
    }
}