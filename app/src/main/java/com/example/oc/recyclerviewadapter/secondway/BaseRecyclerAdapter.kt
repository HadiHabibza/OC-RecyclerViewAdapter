package com.example.oc.recyclerviewadapter.secondway

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.oc.recyclerviewadapter.BaseViewHolder

abstract class BaseRecyclerAdapter<T : Item<T>>() : RecyclerView.Adapter<BaseViewHolder<T>>() {

    private var mItems: MutableList<T> = mutableListOf()
    private val supportedViewHolder = SparseArray<Class<out BaseViewHolder<T>>>()

    override fun getItemViewType(position: Int): Int {
        val item = mItems[position]
        val viewType = item.viewType
        if (supportedViewHolder.indexOfKey(viewType) < 0) {
            supportedViewHolder.put(viewType, item.viewHolderClass)
        }

        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return supportedViewHolder[viewType]!!.getConstructor(View::class.java).newInstance(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(mItems[position])
    }

    override fun getItemCount(): Int {
        return mItems.size
    }
    
}