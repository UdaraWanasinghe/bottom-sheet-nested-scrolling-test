package com.example.bottomsheettest.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.bottomsheettest.R
import com.example.bottomsheettest.adapters.SimplePageAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

internal class OldBottomSheet : BottomSheetDialogFragment(R.layout.bottom_sheet_layout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        // set view pager adapter
        viewPager.adapter = SimplePageAdapter()
        // init tab layout
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "TAB: $position"
        }.attach()
        // init close button
        val closeButton = view.findViewById<MaterialButton>(R.id.close_button)
        closeButton.setOnClickListener {
            dismiss()
        }
        // disable viewpager recyclerview nested scrolling, because I want to
        // use bottom sheet coordinator layout as the nested scrolling parent
        val recyclerView = viewPager.getChildAt(0) as RecyclerView
        recyclerView.isNestedScrollingEnabled = false
        super.onViewCreated(view, savedInstanceState)
    }

}