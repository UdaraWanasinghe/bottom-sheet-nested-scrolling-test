package com.example.bottomsheettest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheettest.R
import com.example.bottomsheettest.ui.adapters.HorizontalRecyclerViewAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

internal class OldBottomSheetDialog :
    BottomSheetDialogFragment(R.layout.horizontal_scrollable_layout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view as RecyclerView
        val layoutInflater = LayoutInflater.from(view.context)
        recyclerView.adapter = HorizontalRecyclerViewAdapter(layoutInflater)
    }

}