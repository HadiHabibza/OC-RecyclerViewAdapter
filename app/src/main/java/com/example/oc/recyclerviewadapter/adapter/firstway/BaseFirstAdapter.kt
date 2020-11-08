package com.example.oc.recyclerviewadapter.adapter.firstway

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseFirstAdapter(vararg viewHolderData: ViewHolderData<FirstWayItem>) : RecyclerView.Adapter<BaseFirstHolder<FirstWayItem>>() {

    private var mItems: MutableList<FirstWayItem> = mutableListOf()
    private val supportedViewHolder = SparseArray<ViewHolderData<FirstWayItem>>()
    private val supportedViewType = HashMap<Class<out FirstWayItem>, Int>()

    init {
        viewHolderData.iterator().forEach {
            supportedViewType[it.itemClass] = it.viewType
            supportedViewHolder.put(it.viewType, it)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return supportedViewType[mItems[position]::class.java]!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseFirstHolder<FirstWayItem> {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return supportedViewHolder[viewType]!!.viewHolderClass.getConstructor(View::class.java).newInstance(view)
    }

    override fun onBindViewHolder(holder: BaseFirstHolder<FirstWayItem>, position: Int) {
        holder.bind(mItems[position])
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun setList(list: List<FirstWayItem>) {
        mItems.clear()
        mItems.addAll(list)
        notifyDataSetChanged()
    }

}