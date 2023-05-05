package com.example.bottomsheettest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withTagValue
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.bottomsheettest.ScrollingViewAssertions.hasNotScrolledVertically
import com.example.bottomsheettest.ScrollingViewAssertions.hasScrolledVertically
import com.example.bottomsheettest.ViewActions.waitForAppear
import com.example.bottomsheettest.ViewActions.waitForScroll
import org.hamcrest.Matchers.`is`
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class OldBottomSheetInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(OldBottomSheetActivity::class.java)

    @Test
    fun testNestedScrollingChild() {
        val page0Matcher = withTagValue(`is`("PAGE_TAG0"))
        val page1Matcher = withTagValue(`is`("PAGE_TAG1"))
        onView(withId(R.id.open_button))
            .perform(click())
        onView(withId(R.id.coordinator))
            .perform(swipeUp(), waitForAppear(page0Matcher))
        onView(page0Matcher)
            .check(hasScrolledVertically())
            .perform(waitForScroll())
        onView(withId(R.id.view_pager))
            .perform(swipeLeft(), waitForAppear(page1Matcher))
        onView(page1Matcher)
            .check(hasNotScrolledVertically())
            .perform(swipeUp(), waitForScroll())
            .check(hasScrolledVertically())
    }

}