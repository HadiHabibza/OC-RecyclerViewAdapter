package com.example.oc.recyclerviewadapter.implementation.firstway

import com.example.oc.recyclerviewadapter.R
import com.example.oc.recyclerviewadapter.adapter.firstway.BaseFirstAdapter
import com.example.oc.recyclerviewadapter.adapter.firstway.ViewHolderData
import com.example.oc.recyclerviewadapter.implementation.firstway.holder.FirstType1ViewHolder
import com.example.oc.recyclerviewadapter.implementation.firstway.holder.FirstType2ViewHolder
import com.example.oc.recyclerviewadapter.implementation.firstway.item.FirstType1Item
import com.example.oc.recyclerviewadapter.implementation.firstway.item.FirstType2Item

class FirstWayAdapter : BaseFirstAdapter(
    ViewHolderData(
        FirstType1Item::class.java,
        R.layout.list_item_type_1,
        FirstType1ViewHolder::class.java
    ),
    ViewHolderData(
        FirstType2Item::class.java,
        R.layout.list_item_type_2,
        FirstType2ViewHolder::class.java
    )
)