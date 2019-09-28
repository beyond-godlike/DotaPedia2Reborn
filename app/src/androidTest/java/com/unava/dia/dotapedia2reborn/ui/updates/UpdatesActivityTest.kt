package com.unava.dia.dotapedia2reborn.ui.updates

import android.content.pm.ActivityInfo
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.unava.dia.dotapedia2reborn.R
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class UpdatesActivityTest {
    @get:Rule
    var mActivityRule: ActivityTestRule<UpdatesActivity> = ActivityTestRule(UpdatesActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testRecyclerView() {
        Espresso.onView(ViewMatchers.withId(R.id.rvUpdates)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvUpdates))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(4))
        mActivityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        Espresso.onView(ViewMatchers.withId(R.id.rvUpdates)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvUpdates)).check(ViewAssertions.matches(ViewMatchers.hasChildCount(5)))
    }

    @Test
    fun testCard() {
        Espresso.onView(ViewMatchers.withId(R.id.tvTitle)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tvDescription)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tvDate)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}