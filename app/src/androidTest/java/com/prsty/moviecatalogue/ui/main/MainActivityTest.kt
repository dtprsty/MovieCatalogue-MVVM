package com.prsty.moviecatalogue.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.prsty.moviecatalogue.R.id.*
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testAppBehaviour() {
        Espresso.onView(allOf(isDisplayed(), withId(rv_data))).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
        Thread.sleep(4000)
        Espresso.onView(allOf(isDisplayed(), withId(rv_data))).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(10, ViewActions.click()))
        Espresso.onView(ViewMatchers.withId(img_poster)).check(matches(isDisplayed()))
        Thread.sleep(4000)
        Espresso.pressBack()
        onView(allOf(withText("TV Show"), isDescendantOfA(withId(tab_main))))
            .perform(click())
            .check(matches(isDisplayed()))
        Espresso.onView(allOf(isDisplayed(), withId(rv_data))).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
        Thread.sleep(4000)
        Espresso.onView(allOf(isDisplayed(), withId(rv_data))).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, ViewActions.click()))
        Espresso.onView(ViewMatchers.withId(txt_movie_name)).check(matches(isDisplayed()))
        Espresso.onView(withId(txt_movie_name)).check(matches(withText("The Flash")))
        Espresso.onView(withId(txt_year)).check(matches(withText("2014")))
        Thread.sleep(4000)
    }
}