package com.example.islamics.estakem

import android.widget.CheckBox
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.islamics.estakem.ui.adapter.MainAdapter
import kotlinx.android.synthetic.main.curr_habits.view.*


class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


    var myCheckBox: CheckBox

    var ItemclickListener:ItemClickListener?= null

    init {


        myCheckBox = itemView.check

        myCheckBox.setOnClickListener(this)
    }


    fun setItemClickListener(ic: ItemClickListener) {
        this.ItemclickListener = ic
    }

    override fun onClick(v: View) {
        this.ItemclickListener?.onItemClick(v, layoutPosition)
    }

    interface ItemClickListener : MainAdapter.ViewHolder.ItemClickListener {

        override fun onItemClick(v: View, pos: Int)
    }
}