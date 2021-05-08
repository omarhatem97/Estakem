package com.example.islamics.estakem.ui

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
import android.widget.ProgressBar
import android.widget.TextView
import com.example.islamics.estakem.ui.data.HabitsData
import com.example.islamics.estakem.ui.adapter.MainAdapter
import com.example.islamics.estakem.MyApplication
import com.example.islamics.estakem.R
import kotlinx.android.synthetic.main.activity_engazat.*

class EngazatActivity : AppCompatActivity() {

    var myshared : SharedPreferences? = null
    val mycards = ArrayList<HabitsData>() // cards to be shown in homepage
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

//        var keys: MutableMap<String,String> = databack1.all as MutableMap<String, String>
//        Log.d("el keys",keys.toString())
//
//        Log.d("checked is ",MyApplication.checked.toString())
//        val thestring :String? = keys["keys"]
//        var tempsize = 0
//        var temp = ""
//
//        if(thestring != null)
//        {
//            if (thestring.length >0)
//                temp = thestring?.substring(0,thestring.length-1)
//        }
//
//        val valuesinOrder = temp?.split(",")?.toTypedArray()

        var totalSum = 0

        if(m.isNotEmpty())
        {
            for ((k,v) in m)
            {

                val strs = v.split(",")?.toTypedArray()

                totalSum+=strs?.get(1).toString().toInt()

                var tocheck = strs?.get(0).toString()
                var thename= "أيام"
                if(tocheck == "صيام الخميس" || tocheck== "صيام الاثنين" ||tocheck == "صلاة الجمعة علي وقتها") {

                    thename = "أسبوع"
                }
                mycards.add(HabitsData(strs?.get(0).toString(), R.drawable.red, R.drawable.pink
                        , R.drawable.coin, strs?.get(1).toString(), strs?.get(2).toString(), strs?.get(3)?.toFloat()!!, true, thename))
            }
        }
        else
        {
            deleteall_but.visibility = View.INVISIBLE
        }

        total.text = totalSum.toString()



        engazaty_recycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        engazaty_recycler.adapter = MainAdapter(mycards,this,"",total,0f,0,"engazat", progressBar3, total)


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
            builder.setPositiveButton("نعم") { dialogInterface, i ->
                clearElement(viewHolder as MainAdapter.ViewHolder) }
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
        val mycards = ArrayList<HabitsData>()

        val progress: ProgressBar? = null
        val percentage: TextView? = null
        engazaty_recycler.adapter = MainAdapter(mycards,this,"",total ,0f,0,"engazat", progressBar3, total)
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


    fun clearElement(viewHolder: MainAdapter.ViewHolder)
    {

        (engazaty_recycler.adapter as MainAdapter).removeItem(viewHolder,"remove_engaz")
    }


    fun updateStatus(){

    }


    fun refresh()
    {
        val mycart = ArrayList<HabitsData>()

        var databack = getSharedPreferences("shared_engaz", 0)
        var databack1 = getSharedPreferences("keyshared_engaz", 0) // to get back the keys

        //val mycards = ArrayList<dataHabits>()
        //the recyclerview
        var m: MutableMap<String,String>
        m = databack.all as MutableMap<String, String>

        var keys: MutableMap<String,String> = databack1.all as MutableMap<String, String>
        Log.d("el keys",keys.toString())

        Log.d("checked is ", MyApplication.checked.toString())
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
            for ((k,v) in m)
            {

                val strs = v.split(",")?.toTypedArray()



                var tocheck = strs?.get(0).toString()
                var thename= "أيام"
                if(tocheck == "صيام الخميس" || tocheck== "صيام الاثنين" ||tocheck == "صلاة الجمعة علي وقتها") {

                    thename = "أسبوع"
                }
                mycart.add(HabitsData(strs?.get(0).toString(), R.drawable.red, R.drawable.pink
                        , R.drawable.coin, strs?.get(1).toString(), strs?.get(2).toString(), strs?.get(3)?.toFloat()!!, true, thename))
            }
        }
        else
        {
            deleteall_but.visibility = View.INVISIBLE
        }

        val progress: ProgressBar? = null
        val percentage: TextView? = null


        engazaty_recycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        engazaty_recycler.adapter = MainAdapter(mycart,this,"",total,0f,0,"engazat", progressBar3, total)
    }
}

