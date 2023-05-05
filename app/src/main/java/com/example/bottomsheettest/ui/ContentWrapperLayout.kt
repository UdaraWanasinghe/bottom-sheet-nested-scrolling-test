package com.example.bottomsheettest.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ScrollingView
import androidx.core.view.ViewCompat

class ContentWrapperLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CoordinatorLayout(context, attrs, defStyleAttr) {

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

}