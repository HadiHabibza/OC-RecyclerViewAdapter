package com.example.oc.recyclerviewadapter.implementation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oc.recyclerviewadapter.R
import com.example.oc.recyclerviewadapter.implementation.firstway.FirstWayAdapter
import com.example.oc.recyclerviewadapter.implementation.firstway.item.FirstType1Item
import com.example.oc.recyclerviewadapter.implementation.firstway.item.FirstType2Item
import com.example.oc.recyclerviewadapter.implementation.secondway.SecondWayAdapter
import com.example.oc.recyclerviewadapter.implementation.secondway.item.SecondType1Item
import com.example.oc.recyclerviewadapter.implementation.secondway.item.SecondType2Item
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = if (arguments!!.getInt(ARG_SECTION_NUMBER) == 1) {
            SecondWayAdapter().apply {
                setList(listOf(SecondType1Item("SecondType1Item"), SecondType2Item("SecondType2Item")))
            }
        } else {
            FirstWayAdapter().apply {
                setList(listOf(FirstType1Item("FirstType1Item"), FirstType2Item("FirstType2Item")))
            }
        }

        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): MainFragment {
            return MainFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}