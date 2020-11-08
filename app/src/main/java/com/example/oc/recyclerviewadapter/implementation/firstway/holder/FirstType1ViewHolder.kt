package com.example.oc.recyclerviewadapter.implementation.firstway.holder

import android.view.View
import com.example.oc.recyclerviewadapter.adapter.firstway.BaseFirstHolder
import com.example.oc.recyclerviewadapter.implementation.firstway.item.FirstType1Item
import kotlinx.android.synthetic.main.list_item_type_1.view.*

class FirstType1ViewHolder(view: View) : BaseFirstHolder<FirstType1Item>(view) {
    override fun bind(data: FirstType1Item?) {
        itemView.itemTitleType1.text = data?.text
    }
}