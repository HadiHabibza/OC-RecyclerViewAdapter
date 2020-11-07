package com.example.oc.recyclerviewadapter.firstway

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.oc.recyclerviewadapter.BaseViewHolder

abstract class BaseRecyclerAdapter<T>(vararg viewHolderData: ViewHolderData<T>) : RecyclerView.Adapter<BaseViewHolder<T>>() {

    private var mItems: MutableList<T> = mutableListOf()
    private val supportedViewHolder = SparseArray<ViewHolderData<T>>()
    private val supportedViewType = HashMap<Class<T>, Int>()

    init {
        viewHolderData.iterator().forEach {
            supportedViewType[it.itemClass] = it.viewType
            supportedViewHolder.put(it.viewType, it)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return supportedViewType[mItems[position]!!::class.java]!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return supportedViewHolder[viewType]!!.viewHolderClass.getConstructor(View::class.java).newInstance(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(mItems[position])
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

}