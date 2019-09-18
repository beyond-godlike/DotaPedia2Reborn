package com.unava.dia.dotapedia2reborn.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.picker.HeroPickerActivity
import org.hamcrest.CoreMatchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @Test
    fun buttonsAvailability() {
        onView(withId(R.id.btPedia)).check(matches(allOf(isDisplayed(), isEnabled(), withText(R.string.btn_pedia))))
        onView(withId(R.id.btUpdates)).check(matches(allOf(isDisplayed(), isEnabled(), withText(R.string.btn_updates))))
        onView(withId(R.id.btHeroConstructor)).check(
            matches(
                allOf(
                    isDisplayed(),
                    isEnabled(),
                    withText(R.string.btn_hero_constructor)
                )
            )
        )
        onView(withId(R.id.btDotabuff)).check(
            matches(
                allOf(
                    isDisplayed(),
                    isEnabled(),
                    withText(R.string.btn_check_mmr)
                )
            )
        )
        onView(withId(R.id.fab)).check(matches(allOf(isDisplayed(), isEnabled(), isClickable())))
    }

    @Test
    fun launchActivityHeroPicker() {
        Intents.init()
        onView(withId(R.id.btHeroConstructor)).perform(click())
        intended(hasComponent(HeroPickerActivity::class.java.name))
        Intents.release()
    }

    @Test
    fun fabTipsVisibilityTest() {
        // TODO add fab string resources, fab logic and test dat shit
    }

    @After
    fun tearDown() {
    }

    @Test
    fun onCreate() {
    }
}