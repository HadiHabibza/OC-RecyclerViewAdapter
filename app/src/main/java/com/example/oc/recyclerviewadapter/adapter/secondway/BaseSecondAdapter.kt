package com.example.oc.recyclerviewadapter.adapter.secondway

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseSecondAdapter : RecyclerView.Adapter<BaseSecondHolder<SecondWayItem>>() {

    private var mItems: MutableList<SecondWayItem> = mutableListOf()
    private val supportedViewHolder = SparseArray<Class<out BaseSecondHolder<SecondWayItem>>>()

    override fun getItemViewType(position: Int): Int {
        val item = mItems[position]
        val viewType = item.viewType
        if (supportedViewHolder.indexOfKey(viewType) < 0) {
            supportedViewHolder.put(viewType, item.viewHolderClass)
        }

        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseSecondHolder<SecondWayItem> {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return supportedViewHolder[viewType]!!.getConstructor(View::class.java).newInstance(view)
    }

    override fun onBindViewHolder(holder: BaseSecondHolder<SecondWayItem>, position: Int) {
        holder.bind(mItems[position])
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun setList(list: List<SecondWayItem>) {
        mItems.clear()
        mItems.addAll(list)
        notifyDataSetChanged()
    }
    
}