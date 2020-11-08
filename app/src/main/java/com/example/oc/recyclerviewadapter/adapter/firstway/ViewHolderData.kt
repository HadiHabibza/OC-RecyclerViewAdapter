package com.example.oc.recyclerviewadapter.adapter.firstway

data class ViewHolderData<out T : FirstWayItem>(
    val itemClass: Class<out T>,
    val viewType: Int,
    val viewHolderClass: Class<out BaseFirstHolder<T>>
)