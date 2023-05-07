package com.example.bottomsheettest.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheettest.R

class VerticalRecyclerViewAdapter(
    private val parentPosition: Int,
    private val layoutInflater: LayoutInflater
) : RecyclerView.Adapter<VerticalRecyclerViewAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(
            R.layout.vertical_scrollview_item, parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val textView = holder.itemView.findViewById<TextView>(R.id.text_view)
        textView.text = "$parentPosition: $position"
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}