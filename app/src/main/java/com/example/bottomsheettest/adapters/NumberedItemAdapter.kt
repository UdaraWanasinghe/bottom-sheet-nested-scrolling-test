package com.example.bottomsheettest.adapters

import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class NumberedItemAdapter(
    private val pageIndex: Int
) : RecyclerView.Adapter<NumberedItemAdapter.ViewHolder>() {

    private val Int.sp
        get() = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            toFloat(),
            Resources.getSystem().displayMetrics
        )

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val text = TextView(parent.context)
        text.layoutParams = RecyclerView.LayoutParams(
            MATCH_PARENT, WRAP_CONTENT
        )
        text.textSize = 18.sp
        text.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        return ViewHolder(text)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val textView = holder.itemView as TextView
        textView.text = "$pageIndex, $position"
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}