package com.example.oc.recyclerviewadapter.secondway

import com.example.oc.recyclerviewadapter.BaseViewHolder

interface Item<T> {
    val viewType: Int
    val viewHolderClass: Class<out BaseViewHolder<T>>
}