package com.example.bottomsheettest.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheettest.R

class HorizontalRecyclerViewAdapter(
    private val layoutInflater: LayoutInflater
) : RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val recyclerView = layoutInflater.inflate(
            R.layout.vertical_scrollable_layout, parent, false
        ) as RecyclerView
        return ViewHolder(recyclerView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recyclerView = holder.recyclerView
        recyclerView.tag = "TAG:$position"
        recyclerView.adapter = VerticalRecyclerViewAdapter(position, layoutInflater)
    }

    class ViewHolder(val recyclerView: RecyclerView) : RecyclerView.ViewHolder(recyclerView)

}