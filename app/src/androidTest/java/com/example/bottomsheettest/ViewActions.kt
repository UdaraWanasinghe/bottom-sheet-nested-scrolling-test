package com.example.bottomsheettest

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.util.HumanReadables
import androidx.test.espresso.util.TreeIterables
import androidx.viewpager2.widget.ViewPager2
import org.hamcrest.CoreMatchers.any
import org.hamcrest.CoreMatchers.anyOf
import org.hamcrest.Matcher
import java.util.concurrent.TimeoutException

object ViewActions {

    fun waitForScroll(): ViewAction {
        return WaitForScrollAction()
    }

    fun waitForAppear(viewMatcher: Matcher<View>, timeout: Long = 2000): ViewAction {
        return WaitForAppearAction(viewMatcher, timeout)
    }

    private class WaitForScrollAction : ViewAction {

        override fun getDescription(): String {
            return "Wait for scroll"
        }

        override fun getConstraints(): Matcher<View> {
            return anyOf(
                ViewMatchers.isAssignableFrom(RecyclerView::class.java),
                ViewMatchers.isAssignableFrom(ViewPager2::class.java)
            )
        }

        override fun perform(uiController: UiController, view: View) {
            val recyclerView = when (view) {
                is ViewPager2 -> {
                    view.getChildAt(0) as RecyclerView
                }

                is RecyclerView -> {
                    view
                }

                else -> {
                    throw PerformException.Builder()
                        .withCause(IllegalArgumentException())
                        .withActionDescription(description)
                        .withViewDescription(HumanReadables.describe(view))
                        .build()
                }
            }
            while (recyclerView.scrollState != RecyclerView.SCROLL_STATE_IDLE) {
                uiController.loopMainThreadForAtLeast(100)
            }
        }

    }

    private class WaitForAppearAction(
        private val viewMatcher: Matcher<View>,
        private val timeout: Long
    ) : ViewAction {

        override fun getDescription(): String {
            return "Wait for view to appear"
        }

        override fun getConstraints(): Matcher<View> {
            return any(View::class.java)
        }

        override fun perform(uiController: UiController, view: View) {
            val endTime = System.currentTimeMillis() + timeout
            do {
                for (child in TreeIterables.breadthFirstViewTraversal(view)) {
                    if (checkVisible(child)) {
                        return
                    }
                }
                uiController.loopMainThreadForAtLeast(50)
            } while (System.currentTimeMillis() < endTime)
            throw PerformException.Builder()
                .withCause(TimeoutException())
                .withActionDescription(description)
                .withViewDescription(HumanReadables.describe(view))
                .build()
        }

        private fun checkVisible(child: View): Boolean {
            return viewMatcher.matches(child) && child.isAttachedToWindow && child.isVisible
        }

    }

}