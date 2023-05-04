package com.example.bottomsheettest

import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class NumberedItemAdapter: RecyclerView.Adapter<NumberedItemAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val text = TextView(parent.context)
        text.layoutParams = RecyclerView.LayoutParams(
            MATCH_PARENT, WRAP_CONTENT
        )
        text.textSize = 24.sp
        text.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        return ViewHolder(text)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val textView = holder.itemView as TextView
        textView.text = "$position"
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}