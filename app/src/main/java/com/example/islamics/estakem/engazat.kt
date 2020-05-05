package com.example.islamics.estakem

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_engazat.*
import kotlinx.android.synthetic.main.activity_main.*

class engazat : AppCompatActivity() {

    var myshared : SharedPreferences? = null
    val mycards = ArrayList<dataHabits>() // cards to be shown in homepage
    var context:Context = this
    var startdate:String=" "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_engazat)


        deleteall_but.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("مسح الكل!")
            builder.setMessage("هل حقا تود بمسح جميع الإنجازات الحالية ؟")
            builder.setPositiveButton("نعم",{dialogInterface, i ->clearAll()  })
            builder.setNegativeButton("لا",{dialogInterface, i ->})
            builder.show()

        }


        //display the recycler view from the engazat shared prefrences

        var databack = getSharedPreferences("shared_engaz", 0)
        var databack1 = getSharedPreferences("keyshared_engaz", 0) // to get back the keys

        //val mycards = ArrayList<dataHabits>()
        //the recyclerview
        var m: MutableMap<String,String>
        m = databack.all as MutableMap<String, String>

        var keys: MutableMap<String,String> = databack1.all as MutableMap<String, String>
        Log.d("el keys",keys.toString())

        Log.d("checked is ",MyApplication.checked.toString())
        val thestring :String? = keys["keys"]
        var tempsize = 0
        var temp = ""

        if(thestring != null)
        {
            if (thestring.length >0)
                temp = thestring?.substring(0,thestring.length-1)
        }

        val valuesinOrder = temp?.split(",")?.toTypedArray()

        var totalSum = 0

        if(m.isNotEmpty())
        {
            for (k in valuesinOrder!!)
            {

                val strs = m[k]?.split(",")?.toTypedArray()

                totalSum+=strs?.get(1).toString().toInt()

                var tocheck = strs?.get(0).toString()
                var thename= "أيام"
                if(tocheck == "صيام الخميس" || tocheck== "صيام الاثنين" ||tocheck == "صلاة الجمعة علي وقتها") {

                    thename = "أسبوع"
                }
                mycards.add(dataHabits(strs?.get(0).toString(), R.drawable.red, R.drawable.pink
                        , R.drawable.coin, strs?.get(1).toString(), strs?.get(2).toString(), strs?.get(3)?.toFloat()!!, true, thename))
            }
        }
        else
        {
            deleteall_but.visibility = View.INVISIBLE
        }

        total.text = totalSum.toString()

        engazaty_recycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        engazaty_recycler.adapter = mainAdapter(mycards,this,"")


        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(engazaty_recycler)
    }



    val itemTouchHelperCallback = object :ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
    {

        override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            //some 3ak

            val builder = AlertDialog.Builder(context)
            builder.setTitle("مسح الانجاز؟")
            builder.setMessage("هل ترغب بمسح هذا الانجاز ؟")
            builder.setPositiveButton("نعم",{dialogInterface, i -> clearElement(viewHolder as mainAdapter.ViewHolder) })
            builder.setNegativeButton("لا",{dialogInterface, i -> refresh()})
            builder.show()

        }

    }



    private fun clearAll()
    {

        var myshared = getSharedPreferences("keyshared_engaz" , 0)
        var editor1: SharedPreferences.Editor = myshared!!.edit()
        myshared = getSharedPreferences("shared_engaz" , 0)
        var editor: SharedPreferences.Editor = myshared!!.edit()
        editor.clear()
        editor.commit()
        editor1.clear()
        editor1.commit()
        val mycards = ArrayList<dataHabits>()
        engazaty_recycler.adapter = mainAdapter(mycards,this,"")
        deleteall_but.visibility = View.INVISIBLE
    }
//
    fun isSubstring(s1: String, s2: String): String
    {
        val M = s1.length
        val N = s2.length

        /* A loop to slide pat[] one by one */
        var idx:Int =0
        for (i in 0..N - M) {
            var j: Int

            /* For current index i, check for
            pattern match */
            j = 0
            while (j < M) {
                if (s2[i + j] != s1[j])
                    break
                j++
            }

            if (j == M)
                idx =  i
        }
        return s2.removeRange(idx , idx+s1.length)

    }


    fun clearElement(viewHolder:mainAdapter.ViewHolder)
    {
        myshared = getSharedPreferences("shared_engaz" , 0)
        var editor: SharedPreferences.Editor = myshared!!.edit()

        var  myshared1 = getSharedPreferences("keyshared_engaz" , 0)
        var editor1: SharedPreferences.Editor = myshared1!!.edit()
        //  MyApplication.globalvar?.remove(mycards[viewHolder.adapterPosition].name);
        editor.remove(mycards[viewHolder.adapterPosition].name)
        editor.commit()

        var value = myshared1.getString("keys","not ofun")
        Log.d("valueBefore" , value)

        //var l=mycards[viewHolder.adapterPosition].name+","
        var newvalue:String = isSubstring(mycards[viewHolder.adapterPosition].name+"," , value)

        Log.d("newvalue", newvalue)

        editor1.putString("keys",newvalue)
        editor1.commit()
        // Log.d("editor1",editor1.toString())
        //end some 3ak
        (engazaty_recycler.adapter as mainAdapter).removeItem(viewHolder)
    }



    fun refresh()
    {
        val mycart = ArrayList<dataHabits>()

        var databack = getSharedPreferences("shared_engaz", 0)
        var databack1 = getSharedPreferences("keyshared_engaz", 0) // to get back the keys

        //val mycards = ArrayList<dataHabits>()
        //the recyclerview
        var m: MutableMap<String,String>
        m = databack.all as MutableMap<String, String>

        var keys: MutableMap<String,String> = databack1.all as MutableMap<String, String>
        Log.d("el keys",keys.toString())

        Log.d("checked is ",MyApplication.checked.toString())
        val thestring :String? = keys["keys"]
        var tempsize = 0
        var temp = ""

        if(thestring != null)
        {
            if (thestring.length >0)
                temp = thestring?.substring(0,thestring.length-1)
        }

        val valuesinOrder = temp?.split(",")?.toTypedArray()

        if(m.isNotEmpty())
        {
            for (k in valuesinOrder!!)
            {

                val strs = m[k]?.split(",")?.toTypedArray()

//                var rating = (strs?.get(3).toString() + "f").toFloat()

                var tocheck = strs?.get(0).toString()
                var thename= "أيام"
                if(tocheck == "صيام الخميس" || tocheck== "صيام الاثنين" ||tocheck == "صلاة الجمعة علي وقتها") {

                    thename = "أسبوع"
                }

                mycart.add(dataHabits(strs?.get(0).toString(), R.drawable.yellow, R.drawable.red
                        , R.drawable.coin, strs?.get(1).toString(), strs?.get(2).toString(), strs?.get(3)?.toFloat()!!, true, thename))
            }
        }
        else
        {
            deleteall_but.visibility = View.INVISIBLE
        }

        engazaty_recycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        engazaty_recycler.adapter = mainAdapter(mycart,this,"")
    }
}

