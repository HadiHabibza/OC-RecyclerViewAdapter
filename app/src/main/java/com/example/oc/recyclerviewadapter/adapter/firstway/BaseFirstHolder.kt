package com.example.oc.recyclerviewadapter.adapter.firstway

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseFirstHolder<out T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(data: @UnsafeVariance T?)

}