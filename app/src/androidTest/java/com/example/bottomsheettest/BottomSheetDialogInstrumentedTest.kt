package com.example.bottomsheettest

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withTagValue
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.bottomsheettest.ScrollingViewAssertions.hasNotScrolledVertically
import com.example.bottomsheettest.ScrollingViewAssertions.hasScrolledVertically
import com.example.bottomsheettest.ViewActionsExtension.scrollToPosition
import com.example.bottomsheettest.ViewActionsExtension.swipeUp
import com.example.bottomsheettest.ViewActionsExtension.waitForAppear
import com.example.bottomsheettest.ViewActionsExtension.waitForScroll
import org.hamcrest.Matchers.`is`
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class BottomSheetDialogInstrumentedTest {

    @Test
    fun testOldBottomSheetDialogNestedScrolling() {
        ActivityScenario
            .launch(OldBottomSheetActivity::class.java)
            .use {
                testNestedScrollingChild()
            }
    }

    @Test
    fun testModifiedBottomSheetDialogNestedScrolling() {
        ActivityScenario
            .launch(NewBottomSheetActivity::class.java)
            .use {
                testNestedScrollingChild()
            }
    }

    private fun testNestedScrollingChild() {
        val itemMatcher1 = withTagValue(`is`("TAG:0"))
        val itemMatcher2 = withTagValue(`is`("TAG:1"))
        onView(withId(R.id.open_button))
            .perform(click())
        onView(withId(R.id.horizontal_scrollable_layout))
            .perform(waitForAppear(itemMatcher1))
        onView(itemMatcher1)
            .check(hasNotScrolledVertically())
            .perform(swipeUp(), waitForScroll())
            .check(hasScrolledVertically())
        onView(withId(R.id.horizontal_scrollable_layout))
            .perform(
                scrollToPosition(1),
                waitForScroll(),
                waitForAppear(itemMatcher2)
            )
        onView(itemMatcher2)
            .check(hasNotScrolledVertically())
            .perform(swipeUp(), waitForScroll())
            .check(hasScrolledVertically())
    }

}