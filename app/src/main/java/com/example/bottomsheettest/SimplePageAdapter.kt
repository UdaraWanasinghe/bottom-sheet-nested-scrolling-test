package com.example.bottomsheettest

import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

internal class SimplePageAdapter: RecyclerView.Adapter<SimplePageAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val pageView = RecyclerView(parent.context).apply {
            layoutParams = RecyclerView.LayoutParams(
                MATCH_PARENT, MATCH_PARENT
            )
            layoutManager = GridLayoutManager(context,2, LinearLayoutManager.VERTICAL, false)
        }
        return ViewHolder(pageView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pageView = holder.itemView as RecyclerView
        pageView.adapter = NumberedItemAdapter()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}