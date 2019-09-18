package com.unava.dia.dotapedia2reborn.ui.heroConstructor.picker

import android.content.pm.ActivityInfo
import androidx.recyclerview.widget.RecyclerView
import androidx.test.rule.ActivityTestRule

import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.ctor.HeroConstructorActivity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Rule

class HeroPickerActivityTest {

    @get:Rule
    var mActivityRule: ActivityTestRule<HeroPickerActivity> = ActivityTestRule(HeroPickerActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun onCreate() {
    }

    @Test
    fun scrollDown() {
        onView(withId(R.id.rvHeroes)).perform(scrollToPosition<RecyclerView.ViewHolder>(116))
    }

    @Test
    fun rotate() {
        onView(withId(R.id.rvHeroes)).check(matches(isDisplayed()))
        mActivityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        onView(withId(R.id.rvHeroes)).check(matches(isDisplayed()))
    }

    @Test
    fun startActivityHeroConstructor() {
        Intents.init()
        onView(withId(R.id.rvHeroes)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        intended(hasComponent(HeroConstructorActivity::class.java.name))
        Intents.release()
    }
}