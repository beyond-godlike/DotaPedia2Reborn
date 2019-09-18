package com.unava.dia.dotapedia2reborn.ui.heroConstructor.ctor

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.unava.dia.dotapedia2reborn.R
import org.hamcrest.core.StringContains.containsString
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HeroConstructorActivityTest {

    @get:Rule
    var mActivityRule: ActivityTestRule<HeroConstructorActivity> = ActivityTestRule(HeroConstructorActivity::class.java
        ,false
        , false
    )

    @Before
    fun setUp() {
    }

    @Test
    fun addLvl() {
        onView(withId(R.id.btPlus)).check(matches(ViewMatchers.isDisplayed())).perform(click())
        onView(withId(R.id.tvLvl)).check(matches(withText(containsString("2"))))
    }

    @Test
    fun minusLvl() {
        onView(withId(R.id.btMinus)).check(matches(ViewMatchers.isDisplayed())).perform(click())
    }

    @Test
    fun resetLvl() {
        onView(withId(R.id.btMinimum)).check(matches(ViewMatchers.isDisplayed())).perform(click())
        onView(withId(R.id.tvLvl)).check(matches(withText(containsString("25"))))
    }

    @Test
    fun maxLvl() {
        onView(withId(R.id.btMaximum)).check(matches(ViewMatchers.isDisplayed())).perform(click())
        onView(withId(R.id.tvLvl)).check(matches(withText(containsString("25"))))
    }

    @Test
    fun addLvlRotate() {
        Intents.init()
        val intent = Intent()
        intent.flags = 2
        mActivityRule.launchActivity(intent)

        onView(withId(R.id.btPlus)).check(matches(ViewMatchers.isDisplayed())).perform(click())
        onView(withId(R.id.tvLvl)).check(matches(withText(containsString("2"))))
        mActivityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        onView(withId(R.id.tvLvl)).check(matches(withText(containsString("2"))))
    }

    @Test
    fun maxLvlRotate() {
        onView(withId(R.id.btMaximum)).check(matches(ViewMatchers.isDisplayed())).perform(click())
        mActivityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        onView(withId(R.id.tvLvl)).check(matches(withText(containsString("25"))))
    }

    @After
    fun tearDown() {
    }
}