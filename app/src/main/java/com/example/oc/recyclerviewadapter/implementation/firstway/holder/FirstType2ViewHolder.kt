package com.example.oc.recyclerviewadapter.implementation.firstway.holder

import android.view.View
import com.example.oc.recyclerviewadapter.adapter.firstway.BaseFirstHolder
import com.example.oc.recyclerviewadapter.implementation.firstway.item.FirstType2Item
import kotlinx.android.synthetic.main.list_item_type_2.view.*

class FirstType2ViewHolder(view: View) : BaseFirstHolder<FirstType2Item>(view) {
    override fun bind(data: FirstType2Item?) {
        itemView.itemTitleType2.text = data?.text
    }
}