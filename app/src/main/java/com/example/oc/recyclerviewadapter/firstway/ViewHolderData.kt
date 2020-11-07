package com.example.oc.recyclerviewadapter.firstway

import com.example.oc.recyclerviewadapter.BaseViewHolder

data class ViewHolderData<T> (
    val itemClass: Class<T>,
    val viewType: Int,
    val viewHolderClass: Class<out BaseViewHolder<T>>
)