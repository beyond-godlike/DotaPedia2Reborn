package com.unava.dia.dotapedia2reborn.ui.dotabuff

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.unava.dia.dotapedia2reborn.R
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import com.unava.dia.dotapedia2reborn.ui.dotabuff.checker.MmrCheckerActivity
import com.unava.dia.dotapedia2reborn.ui.dotabuff.history.MatchesHistoryActivity
import com.unava.dia.dotapedia2reborn.ui.dotabuff.match.MatchActivity
import org.hamcrest.CoreMatchers.allOf
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class DotabuffActivityTest {

    @get:Rule
    var mActivityRule: ActivityTestRule<DotabuffActivity> = ActivityTestRule(DotabuffActivity::class.java)

    @Before
    fun setUp() {
    }

    @Test
    fun correctAccountId() {
        Intents.init()
        onView(withId(R.id.btFindHistory)).check(matches(allOf(isDisplayed(), isEnabled(), withText(R.string.bt_go))))
        onView(withId(R.id.etFindHistory)).perform(typeText("5026174779"))
        onView(withId(R.id.btFindHistory)).perform(click())

        intended(hasComponent(MatchesHistoryActivity::class.java.name))
        Intents.release()
    }

    @Test
    fun wrongAccountId() {
        onView(withId(R.id.etFindHistory)).perform(typeText("3122"))
        onView(withId(R.id.btFindHistory)).perform(click())
    }

    @Test
    fun emptyAccountId() {
        onView(withId(R.id.etFindHistory)).perform(typeText(""))
        onView(withId(R.id.btFindHistory)).perform(click())
    }

    @Test
    fun correctPlayerId() {
        Intents.init()

        onView(withId(R.id.btFindPlayer)).check(matches(allOf(isDisplayed(), isEnabled(), withText(R.string.bt_go))))
        onView(withId(R.id.etFindPlayer)).perform(typeText("5026174779"))
        onView(withId(R.id.btFindPlayer)).perform(click())

        intended(hasComponent(MmrCheckerActivity::class.java.name))
        Intents.release()
    }

    @Test
    fun wrongPlayerId() {
        onView(withId(R.id.etFindPlayer)).perform(typeText("000001"))
        onView(withId(R.id.btFindPlayer)).perform(click())
    }

    @Test
    fun emptyPlayerId() {
        onView(withId(R.id.etFindPlayer)).perform(typeText(""))
        onView(withId(R.id.btFindPlayer)).perform(click())
    }

    @Test
    fun correctMatchId() {
        Intents.init()
        onView(withId(R.id.btFindMatch)).check(matches(allOf(isDisplayed(), isEnabled(), withText(R.string.bt_go))))
        onView(withId(R.id.etFindMatch)).perform(typeText("5026174779"))
        onView(withId(R.id.btFindMatch)).perform(click())

        intended(hasComponent(MatchActivity::class.java.name))
        Intents.release()
    }

    @Test
    fun wrongMatchId() {
        onView(withId(R.id.etFindMatch)).perform(typeText("000001"))
        onView(withId(R.id.btFindMatch)).perform(click())
    }

    @Test
    fun emptyMatchId() {
        onView(withId(R.id.etFindMatch)).perform(typeText(""))
        onView(withId(R.id.btFindMatch)).perform(click())
    }

    @After
    fun tearDown() {
    }
}