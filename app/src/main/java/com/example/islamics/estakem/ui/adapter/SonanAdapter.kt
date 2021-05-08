package com.example.islamics.estakem.ui.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.islamics.estakem.ui.data.FaraedData
import com.example.islamics.estakem.R
import com.example.islamics.estakem.ui.SalaActivity
import kotlinx.android.synthetic.main.card_frayed.view.iconpic
import kotlinx.android.synthetic.main.card_frayed.view.thickbar
import kotlinx.android.synthetic.main.card_frayed.view.thinbar
import kotlinx.android.synthetic.main.card_sonan_mahgora.view.*

class SonanAdapter (val input: ArrayList<FaraedData>) : RecyclerView.Adapter<SonanAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.card_sonan_mahgora,parent,false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return input.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data : FaraedData = input[position]
        holder.Thickbar.setImageResource(data.thickbar)
        holder.Thinbar.setImageResource(data.thinbar)
        holder.iconpic.setImageResource(data.iconimg)
        holder.name.text = data.name
        holder.myitemdata = data

    }

    class ViewHolder (itemview : View, var myitemdata: FaraedData?=null) : RecyclerView.ViewHolder(itemview) {

        init {
            itemview.setOnClickListener {
                val intent = Intent(itemview.context , SalaActivity::class.java)
                intent.putExtra("sona_name" , myitemdata?.name)
                itemview.context.startActivity(intent)
            }
        }


        val name  = itemview.sona_name as TextView
        val Thickbar = itemview.thickbar as ImageView
        val Thinbar = itemview.thinbar as ImageView
        val iconpic = itemview.iconpic as ImageView

    }

}