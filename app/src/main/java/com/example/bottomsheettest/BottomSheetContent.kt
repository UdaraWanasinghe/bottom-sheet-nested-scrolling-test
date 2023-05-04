package com.example.bottomsheettest

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ScrollingView
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout

internal class BottomSheetContent(
    context: Context
) : CoordinatorLayout(context) {

    init {
        createContent()
    }

    override fun onStartNestedScroll(child: View, target: View, axes: Int, type: Int): Boolean {
        if (axes == ViewCompat.SCROLL_AXIS_VERTICAL &&
            target is ScrollingView &&
            target.computeVerticalScrollOffset() == 0
        ) {
            // force recyclerview to use bottom sheet coordinator layout
            // as the nested scrolling parent
            return false
        }
        return super.onStartNestedScroll(child, target, axes, type)
    }

    private fun createContent() {
        addView(
            AppBarLayout(context).apply {
                layoutParams = LayoutParams(
                    MATCH_PARENT, WRAP_CONTENT
                )
                addView(
                    CollapsingToolbarLayout(context).apply {
                        layoutParams = AppBarLayout.LayoutParams(
                            MATCH_PARENT, WRAP_CONTENT
                        ).apply {
                            scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or
                                    AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
                        }
                        addView(
                            LinearLayout(context).apply {
                                layoutParams = CollapsingToolbarLayout.LayoutParams(
                                    MATCH_PARENT, WRAP_CONTENT
                                ).apply {
                                    collapseMode =
                                        CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PIN
                                }
                                orientation = LinearLayout.VERTICAL
                                addView(
                                    MaterialToolbar(context).apply {
                                        layoutParams = LinearLayout.LayoutParams(
                                            MATCH_PARENT, WRAP_CONTENT
                                        )
                                        addView(
                                            TextView(context).apply {
                                                layoutParams = Toolbar.LayoutParams(
                                                    WRAP_CONTENT, WRAP_CONTENT
                                                )
                                                text = "Bottom Sheet"
                                                setTextColor(Color.WHITE)
                                                textSize = 20f
                                            }
                                        )
                                        addView(
                                            MaterialButton(context).apply {
                                                id = R.id.close_button
                                                layoutParams = Toolbar.LayoutParams(
                                                    36.dp, 36.dp
                                                ).apply {
                                                    gravity = Gravity.RIGHT
                                                }
                                                insetTop = 0
                                                insetBottom = 0
                                                setPadding(
                                                    6.dp,
                                                    0,
                                                    6.dp,
                                                    0
                                                )
                                                icon = ContextCompat.getDrawable(
                                                    context,
                                                    R.drawable.baseline_close_24
                                                )
                                                iconPadding = 0
                                                iconTint = ColorStateList.valueOf(Color.WHITE)
                                            }
                                        )
                                    }
                                )

                                addView(
                                    TabLayout(context).apply {
                                        id = R.id.tab_layout
                                        layoutParams = LinearLayout.LayoutParams(
                                            MATCH_PARENT, WRAP_CONTENT
                                        )
                                    }
                                )
                            }
                        )
                    }
                )
            }
        )
        addView(
            ViewPager2(context).apply {
                id = R.id.view_pager
                layoutParams = LayoutParams(
                    MATCH_PARENT, MATCH_PARENT
                ).apply {
                    behavior = AppBarLayout.ScrollingViewBehavior()
                }
            }
        )
    }

}