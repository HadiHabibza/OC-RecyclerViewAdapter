package com.example.oc.recyclerviewadapter.implementation.secondway.holder

import android.view.View
import com.example.oc.recyclerviewadapter.adapter.secondway.BaseSecondHolder
import com.example.oc.recyclerviewadapter.implementation.secondway.item.SecondType2Item
import kotlinx.android.synthetic.main.list_item_type_2.view.*

class SecondType2ViewHolder(view: View) : BaseSecondHolder<SecondType2Item>(view) {
    override fun bind(data: SecondType2Item?) {
        itemView.itemTitleType2.text = data?.text
    }
}