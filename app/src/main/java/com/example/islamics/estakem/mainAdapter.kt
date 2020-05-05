package com.example.islamics.estakem

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.support.v7.widget.RecyclerView

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.card_frayed.view.fardname
import kotlinx.android.synthetic.main.card_frayed.view.thickbar
import kotlinx.android.synthetic.main.card_frayed.view.thinbar
import kotlinx.android.synthetic.main.curr_habits.view.*

import android.widget.CheckBox
import org.w3c.dom.Text


class mainAdapter (val input: ArrayList<dataHabits>,var ctx: Context,var startdate:String) : RecyclerView.Adapter<mainAdapter.ViewHolder>()
{

    var prefrences =this.ctx.getSharedPreferences("shared",0)
    var editor: SharedPreferences.Editor = prefrences!!.edit()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mainAdapter.ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.curr_habits,parent,false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return input.size
    }

    override fun onBindViewHolder(holder: mainAdapter.ViewHolder, position: Int) {
        //myshared?.getString("بر الوالدين","شششششش")
        val data :dataHabits = input[position]
        holder.Thickbar.setImageResource(data.thickbar)
        holder.Thinbar.setImageResource(data.thinbar)
        holder.name.text = data.name
        holder.coins.setImageResource(data.coinimg)
        holder.numdays.text = data.numdays
        holder.numcoins.text = data.numofcoins
        holder.ratingbar.rating = data.rating
        holder.check.isChecked = data.check
        holder.myitemdata = data
        holder.day_week.text = data.DayWeek

        //shared prefrences


        //3ak
        //checkbox check
        holder.setItemClickListener(object : MyHolder.ItemClickListener {

          //  var editor: SharedPreferences.Editor = myshared!!.edit()
            override fun onItemClick(v: View, pos: Int) {
                val myCheckBox = v as CheckBox


                if (myCheckBox.isChecked)
                {

                    //var myshared :SharedPreferences = context.getSharedPreferences("shared" , 0)
                    Log.d("in adapter","reached")
                    var Coinnewvalue:Int = holder.numcoins.text.toString().toInt() + 5
                    //var myglobal = MyApplication() // to use global variable
                    MyApplication.checked = 1
                    Log.d("aywa ana true",MyApplication.checked.toString())
                    holder.numcoins.text = Coinnewvalue.toString()
                    holder.check.isChecked = true
                    var numdays_separated=data.numdays?.split("/")?.toTypedArray()
                    var ratingnew:Float = (Coinnewvalue.toString()+"f").toFloat()/numdays_separated[1].toFloat()
                    holder.ratingbar.rating = ratingnew
                   // MyApplication?.globalvar = mutableMapOf(Pair(data.name, Pair(holder.check.isChecked.toString(),Coinnewvalue.toString())))
                    editor.putString(data.name, data.name + ","
                            + startdate+ ","
                            + Coinnewvalue + ","
                            + holder.ratingbar.rating + ","
                            + holder.check.isChecked + "," + numdays_separated[1])
                    editor.commit()


                    Log.d("m in adapter","3mlt t3del 5las")
                    //myglobal.s = "omar hatem"
                    //myglobal.checked = 1
                    //var dayprec:String=
                   // editor.putString(data.name,data.name+","+data.numdays+","+Coinnewvalue.toString()
                       //              +data.rating+"true")
                 //   Log.d("status","reached")
                    //editor.commit()

                  //  Log.d("shimaw is :", myglobal.globalvar?.get(data.name)?.second.toString())
3
                }
                else if (!myCheckBox.isChecked)
                {
                    var Coinnewvalue:Int = holder.numcoins.text.toString().toInt() - 5
                    var myglobal = MyApplication() // to use global variable
                    holder.numcoins.text = Coinnewvalue.toString()
                    holder.check.isChecked = false
                    var numdays_separated=data.numdays?.split("/")?.toTypedArray()
                    var ratingnew:Float = (Coinnewvalue.toString()+"f").toFloat()/numdays_separated[1].toFloat()
                    holder.ratingbar.rating = ratingnew
                    editor.putString(data.name, data.name + ","
                            + startdate+ ","
                            + Coinnewvalue + ","
                            + holder.ratingbar.rating + ","
                            + holder.check.isChecked + "," + numdays_separated[1])
                    editor.commit()
                }
            }
        })

        //end3ak

    }

    class ViewHolder (itemview : View,var myitemdata:dataHabits?=null) : RecyclerView.ViewHolder(itemview), View.OnClickListener {
        init {
            itemview.setOnClickListener {
                val intent = Intent(itemview.context , review::class.java)
                intent.putExtra("fareda_name" , myitemdata?.name)
                intent.putExtra("fareda_numdays" , numdays.text.toString())
                intent.putExtra("fareda_numofcoins" , numcoins.text.toString())

                itemview.context.startActivity(intent)
            }
        }

        val name  = itemview.fardname as TextView
        val Thickbar = itemview.thickbar as ImageView
        val Thinbar = itemview.thinbar as ImageView
        val coins = itemview.coinimg as ImageView
        val numcoins = itemview.numcoins as TextView
        val numdays = itemview.numdays as TextView
        val ratingbar = itemview.ratingBar as RatingBar
        val check = itemview.check as CheckBox
        val day_week = itemview.textView9 as TextView

        var myCheckBox: CheckBox

        var ItemclickListener:ItemClickListener?= null

        init {


            myCheckBox = itemView.check

            myCheckBox?.setOnClickListener(this)
        }


        fun setItemClickListener(ic: MyHolder.ItemClickListener) {
            this.ItemclickListener = ic
        }

        override fun onClick(v: View) {
            this.ItemclickListener?.onItemClick(v, layoutPosition)
        }

        interface ItemClickListener {

            fun onItemClick(v: View, pos: Int)
        }


    }


    fun removeItem(viewHolder:RecyclerView.ViewHolder)
    {
        MyApplication.keyname = input[viewHolder.adapterPosition].name
        Log.d("item to remove", input[viewHolder.adapterPosition].name)
        input.removeAt(viewHolder.adapterPosition)
        notifyItemRemoved(viewHolder.adapterPosition)
    }




}


