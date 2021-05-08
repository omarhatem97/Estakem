package com.example.islamics.estakem.ui.adapter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
import com.example.islamics.estakem.ui.data.HabitsData
import com.example.islamics.estakem.MyApplication
import com.example.islamics.estakem.MyHolder
import com.example.islamics.estakem.R
import com.example.islamics.estakem.ui.ReviewActivity
import java.text.SimpleDateFormat


class MainAdapter (val input: ArrayList<HabitsData>, var ctx: Context, var startdate:String, var totalcoins: TextView
                   , var totalrating:Float, var numCards:Int, var activityname:String
                   , var progress:ProgressBar, var percentage:TextView) : RecyclerView.Adapter<MainAdapter.ViewHolder>()
{

    var prefrences =this.ctx.getSharedPreferences("shared",0)
    var editor: SharedPreferences.Editor = prefrences!!.edit()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.curr_habits,parent,false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return input.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //myshared?.getString("بر الوالدين","شششششش")
        val data : HabitsData = input[position]
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
                    if(activityname != "engazat")
                    {
                        //var myshared :SharedPreferences = context.getSharedPreferences("shared" , 0)
                        Log.d("in adapter","reached")
                        var Coinnewvalue:Int = holder.numcoins.text.toString().toInt() + 5
                        //var myglobal = MyApplication() // to use global variable
                        MyApplication.checked = 1
                        Log.d("aywa ana true", MyApplication.checked.toString())
                        holder.numcoins.text = Coinnewvalue.toString()
                        holder.check.isChecked = true
                        var numdays_separated=data.numdays?.split("/")?.toTypedArray()
                        var ratingnew:Float = (Coinnewvalue.toString()+"f").toFloat()/numdays_separated[1].toFloat()

                        //step 1
                        totalrating = totalrating - holder.ratingbar.rating + ratingnew

                        //step 2
                        progress.progress = ((totalrating / (numCards*5)) *100).toInt()
                        percentage.text = ((totalrating / (numCards*5)) *100).toInt().toString()

                        //step 3
                        totalcoins.text = (totalcoins.text.toString().toInt() + 5).toString()

                        holder.ratingbar.rating = ratingnew
                        // MyApplication?.globalvar = mutableMapOf(Pair(data.name, Pair(holder.check.isChecked.toString(),Coinnewvalue.toString())))
                        editor.putString(data.name, data.name + ","
                                + startdate+ ","
                                + Coinnewvalue + ","
                                + holder.ratingbar.rating + ","
                                + holder.check.isChecked + "," + numdays_separated[1])
                        editor.commit()


                        Log.d("m in adapter","3mlt t3del 5las")
                    }

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
                    if(activityname != "engazat")
                    {
                        var Coinnewvalue:Int = holder.numcoins.text.toString().toInt() - 5
                        var myglobal = MyApplication() // to use global variable
                        holder.numcoins.text = Coinnewvalue.toString()
                        holder.check.isChecked = false
                        var numdays_separated=data.numdays?.split("/")?.toTypedArray()
                        var ratingnew:Float = (Coinnewvalue.toString()+"f").toFloat()/numdays_separated[1].toFloat()

                        //step 1
                        totalrating = totalrating - holder.ratingbar.rating + ratingnew

                        //step 2
                        progress.progress = ((totalrating / (numCards*5)) *100).toInt()
                        percentage.text = ((totalrating / (numCards*5)) *100).toInt().toString()

                        //step 3
                        totalcoins.text = (totalcoins.text.toString().toInt() - 5).toString()

                        holder.ratingbar.rating = ratingnew
                        editor.putString(data.name, data.name + ","
                                + startdate+ ","
                                + Coinnewvalue + ","
                                + holder.ratingbar.rating + ","
                                + holder.check.isChecked + "," + numdays_separated[1])
                        editor.commit()
                    }

                }
            }
        })

        //end3ak

    }

    class ViewHolder (itemview : View,var myitemdata: HabitsData?=null) : RecyclerView.ViewHolder(itemview), View.OnClickListener {
        init {
            itemview.setOnClickListener {
                val intent = Intent(itemview.context , ReviewActivity::class.java)
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

        var ItemclickListener: ItemClickListener?= null

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


    fun removeItem(viewHolder:RecyclerView.ViewHolder , name:String)
    {

        if(name == "addengaz")
        {
            Log.d("enter", "addengaz")
            //step 1 : save item to shared engaz

            var myshared_engaz = this.ctx.getSharedPreferences("shared_engaz", 0)

           // var myshared1_engaz = this.ctx.getSharedPreferences("keyshared_engaz", 0)

            var editor_engaz: SharedPreferences.Editor = myshared_engaz!!.edit()
           // var editor1_engaz: SharedPreferences.Editor = myshared1_engaz!!.edit()

            // var card = mycards[viewHolder.adapterPosition] //card to be added in engazat
            //Log.d("you", card.name)

            var databack = this.ctx.getSharedPreferences("shared", 0)
          //  var databack1 = this.ctx.getSharedPreferences("keyshared", 0)

            var last_num = (myshared_engaz.all.size + 1).toString()  // store the keys of engazat as 1,2,3,4 .....


            var v = databack.getString(input[viewHolder.adapterPosition].name, "toz")

            val strs = v?.split(",")?.toTypedArray()
            Log.d("array:", strs?.get(0).toString())

            var diff = calc_day(strs?.get(1).toString(), input[viewHolder.adapterPosition].name)

            Log.d("numcoinsandrating", v.toString())

            var card = input[viewHolder.adapterPosition]


            Log.d("cardcoin",strs?.get(2).toString()  )
            Log.d("cardrating",strs?.get(3))
            //hena 8yart
            editor_engaz.putString(last_num, card.name + "," + strs?.get(2).toString() + "," + diff + "/" +strs?.get(5).toString()+','
                                    + strs?.get(3))
            editor_engaz.commit()



            //step 2 see changes on progressbar and total coins
            //step 1
            totalrating = totalrating - strs?.get(3)!!.toFloat()

            //step 2
            progress.progress = ((totalrating / (numCards*5)) *100).toInt()
            percentage.text = ((totalrating / (numCards*5)) *100).toInt().toString()

            //step 3
            totalcoins.text = (totalcoins.text.toString().toInt() - strs?.get(2).toInt()).toString()


            //step 2 : removing item from the recycler view

            Log.d("item to remove", input[viewHolder.adapterPosition].name)

            //remove item from shared preferences
            var myshared = this.ctx.getSharedPreferences("shared",0)
            var editor: SharedPreferences.Editor = myshared!!.edit()


            Log.d("removing" ,input[viewHolder.adapterPosition].name)
            editor.remove(input[viewHolder.adapterPosition].name)
            editor.commit()



            //removing from recycler view
            input.removeAt(viewHolder.adapterPosition)
            notifyItemRemoved(viewHolder.adapterPosition)

        }

        else if(name == "remove_engaz")
        {
            //to remove the item from the recycler view of engazaty and removing it from sharedpref
            Log.d("enter", "remove")

            //step 1 : remove item from shared pref
            var myshared_engaz = this.ctx.getSharedPreferences("shared_engaz", 0)
            var editor_engaz: SharedPreferences.Editor = myshared_engaz!!.edit()

                    //finding the matching item to remove from the shared pref (engaz)

            var m: MutableMap<String,String> = myshared_engaz.all as MutableMap<String, String>
           // editor_engaz.putString(last_num, card.name + "," + card.numofcoins + "," +card.numdays + "," + card.rating+ ","+last_num)

            var card  = input[viewHolder.adapterPosition]
            for ((k,v) in m)
            {
                val strs = v.split(",")?.toTypedArray()

                Log.d("tocompare" , card.name+','+card.numofcoins+','+card.numdays+','+card.rating)
                Log.d("tocomparewith",strs[0]+','+strs[1]+','+strs[2]+','+card.rating)
                if(card.name == strs[0] && card.numofcoins == strs[1] && card.numdays == strs[2] && card.rating.toString() == strs[3])
                {
                    totalcoins.text = (totalcoins.text.toString().toInt() - card.numofcoins.toInt()).toString()
                    editor_engaz.remove(k)
                    editor_engaz.commit()
                }
            }


            //step 2 : removing from recycler view
            input.removeAt(viewHolder.adapterPosition)
            notifyItemRemoved(viewHolder.adapterPosition)

        }

        else
        {
             /** So you wnat to remove the element and not add it to any shared pref **/

             var databack = this.ctx.getSharedPreferences("shared", 0)
            //  var databack1 = this.ctx.getSharedPreferences("keyshared", 0)



            var v = databack.getString(input[viewHolder.adapterPosition].name, "toz")

            val strs = v?.split(",")?.toTypedArray()

            //step 2 see changes on progressbar and total coins
            //step 1
            totalrating -= strs?.get(3)!!.toFloat()

            //step 2
            progress.progress = ((totalrating / (numCards*5)) *100).toInt()
            percentage.text = ((totalrating / (numCards*5)) *100).toInt().toString()

            //step 3
            totalcoins.text = (totalcoins.text.toString().toInt() - strs?.get(2).toInt()).toString()


            //step 2 : removing item from the recycler view

            Log.d("item to remove", input[viewHolder.adapterPosition].name)

            //remove item from shared preferences
            var myshared = this.ctx.getSharedPreferences("shared",0)
            var editor: SharedPreferences.Editor = myshared!!.edit()


            Log.d("removing" ,input[viewHolder.adapterPosition].name)
            editor.remove(input[viewHolder.adapterPosition].name)
            editor.commit()



            //removing from recycler view
            input.removeAt(viewHolder.adapterPosition)
            notifyItemRemoved(viewHolder.adapterPosition)
        }




    }



    /**********************************/
    fun calc_day(startdate_String: String, name: String): Long {
        val myFormat = SimpleDateFormat("dd MM yyyy")
        val inputString1 = get_correct_format(startdate_String)
        val inputString2 = get_correct_format(java.util.Calendar.getInstance().time.toString())


        val date1 = myFormat.parse(inputString1)
        val date2 = myFormat.parse(inputString2)
        val diff = (date2.time - date1.time) / (1000 * 3600 * 24)
        //System.out.println("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS))

        val seven: Long = 7
        if (name == "صيام الخميس" || name == "صيام الاثنين" || name == "صلاة الجمعة علي وقتها") {
            var result = diff.toInt() / 7
            if (diff < 7.toLong()) return (result + 1).toLong()
            else if (diff.toInt() % 7 == 0) {
                Log.d("diffnew", result.toString())
                Log.d("diffnfsaha", diff.toString())
                return (result + 1).toLong()
            }

            return result.toLong()
        }

        return diff + 1
    }


    fun get_correct_format(s: String): String {
        var m: MutableMap<String, String> = mutableMapOf("Jan" to "01", "Feb" to "02", "Mar" to "03",
                "Apr" to "04", "May" to "05", "Jun" to "06", "Jul" to "07", "Aug" to "08", "Sep" to "09",
                "Oct" to "10", "Nov" to "11", "Dec" to "12")
        var temp = s?.split(" ")?.toTypedArray()
        var res: String = ""
        // Log.d("temp[2]" , temp[2])
        res += temp[2] + " " + m[temp[1]] + " " + temp[temp.size - 1]
        return res

    }

    /********************************/


}


