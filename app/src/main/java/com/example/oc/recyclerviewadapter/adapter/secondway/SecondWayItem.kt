package com.example.oc.recyclerviewadapter.adapter.secondway

interface SecondWayItem {
    val viewType: Int
    val viewHolderClass: Class<out BaseSecondHolder<SecondWayItem>>
}