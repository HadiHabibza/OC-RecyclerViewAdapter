package com.example.oc.recyclerviewadapter.implementation.secondway.item

import com.example.oc.recyclerviewadapter.R
import com.example.oc.recyclerviewadapter.adapter.secondway.BaseSecondHolder
import com.example.oc.recyclerviewadapter.adapter.secondway.SecondWayItem
import com.example.oc.recyclerviewadapter.implementation.secondway.holder.SecondType1ViewHolder

data class SecondType1Item(val text: String) : SecondWayItem {
    override val viewType: Int
        get() = R.layout.list_item_type_1

    override val viewHolderClass: Class<out BaseSecondHolder<SecondWayItem>>
        get() = SecondType1ViewHolder::class.java
}