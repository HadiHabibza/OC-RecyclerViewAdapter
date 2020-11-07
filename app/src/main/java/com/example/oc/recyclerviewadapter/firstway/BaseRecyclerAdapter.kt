package com.example.oc.recyclerviewadapter.firstway

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.oc.recyclerviewadapter.BaseViewHolder

abstract class BaseRecyclerAdapter<T>(viewHolderMap: Map<Class<T>, Class<out BaseViewHolder<T>>>) : RecyclerView.Adapter<BaseViewHolder<T>>() {

    private var mItems: MutableList<T> = mutableListOf()
    private val supportedViewHolder = SparseArray<Class<out BaseViewHolder<T>>>()
    private val supportedViewType = HashMap<Class<T>, Int>()

    init {
        var viewType = 0
        viewHolderMap.forEach { (key, value) ->
            supportedViewType[key] = viewType
            supportedViewHolder.put(viewType, value)
            viewType++
        }
    }

    override fun getItemViewType(position: Int): Int {
        return supportedViewType[mItems[position]!!::class.java]!!
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