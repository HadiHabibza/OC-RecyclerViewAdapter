package com.example.oc.recyclerviewadapter.adapter.secondway

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseSecondHolder<out T : SecondWayItem>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(data: @UnsafeVariance T?)

}