package com.example.oc.recyclerviewadapter.implementation.secondway.holder

import android.view.View
import com.example.oc.recyclerviewadapter.adapter.secondway.BaseSecondHolder
import com.example.oc.recyclerviewadapter.implementation.secondway.item.SecondType1Item
import kotlinx.android.synthetic.main.list_item_type_1.view.*

class SecondType1ViewHolder(view: View) : BaseSecondHolder<SecondType1Item>(view) {
    override fun bind(data: SecondType1Item?) {
        itemView.itemTitleType1.text = data?.text
    }
}