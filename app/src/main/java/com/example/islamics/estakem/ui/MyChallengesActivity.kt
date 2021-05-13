package com.example.islamics.estakem.ui

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.islamics.estakem.*
import com.example.islamics.estakem.ui.adapter.MainAdapter
import com.example.islamics.estakem.ui.data.HabitsData
import kotlinx.android.synthetic.main.activity_engazat.activityEngazatDeleteAllEngazatButton
import kotlinx.android.synthetic.main.activity_mychallenges.*


import java.text.SimpleDateFormat

class MyChallengesActivity : AppCompatActivity() {

    var myshared: SharedPreferences? = null
    val mycards = ArrayList<HabitsData>() // cards to be shown in homepage
    var startdate: String = " "


//    override fun onResume() {
//        super.onResume()
//        reload()
//    }


    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mychallenges)


        /*****for notifications********/

        val pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE)
        Log.d("shi5ara", pref.getBoolean("activity_executed", false).toString())
        if (!pref.getBoolean("activity_executed", false)) {
            val ed = pref.edit()
            ed.putBoolean("activity_executed", true)
            ed.commit()
            //Log.d("shi5ara",pref.getBoolean("activity_executed", false).toString())
            omar(51)
        }

        /******5alas*********/

        /********debugging only**********/

        var toz = ",الفجر,الظهر,العصر,المغرب,العشاء"
        Log.d("toz" , isSubstring(toz,"العصر"))
        /*********************************/



        newDay_remove_check()
        myshared = getSharedPreferences("shared", 0)
        var editor: SharedPreferences.Editor = myshared!!.edit()


        activityEngazatDeleteAllEngazatButton.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("مسح الكل!")
            builder.setMessage("هل حقا تود بمسح جميع التحديات الحالية ؟")
            builder.setPositiveButton("نعم", { dialogInterface, i -> clearAll() })
            builder.setNegativeButton("لا", { dialogInterface, i -> })
            builder.show()
        }





        tanshet.setOnClickListener {
            reload()

//            var startdate: String = " "
//        newDay_remove_check()
//        val mycard = ArrayList<dataHabits>()
//
//
//        //habd gded----------------------------------------
//        //newDay_remove_check()
//        var databack = getSharedPreferences("shared", 0)
//        var databack1 = getSharedPreferences("keyshared", 0) // to get back the keys
//
//
//        //the recyclerview
//        var m: MutableMap<String, String>
//        m = databack.all as MutableMap<String, String>
//
//        var keys: MutableMap<String, String> = databack1.all as MutableMap<String, String>
//        Log.d("el keys", keys.toString())
//
//        //Log.d("checked is ",MyApplication.checked.toString())
//        val thestring: String? = keys["keys"]
//        // val temp = thestring?.substring(0,thestring.length-1)
//
//        var temp = ""
//
//        if (thestring != null) {
//            if (thestring.length > 0)
//                temp = thestring?.substring(0, thestring.length - 1)
//        }
//
//        val valuesinOrder = temp?.split(",")?.toTypedArray()
//        //val valuesinOrder = temp?.split(",")?.toTypedArray()
//        Log.d("ydenela", valuesinOrder?.get(0).toString())
//
//        var totalsum = 0
//        var totalrating = 0f
//        var totalnum = valuesinOrder.size
//        if (m.isNotEmpty()) {
//            Log.d("elmap", m.toString())
//            for (k in valuesinOrder!!) {
//
//                val strs = m[k]?.split(",")?.toTypedArray()
//                startdate = strs?.get(1).toString()
//
//                var rating = (strs?.get(2).toString() + "f").toFloat() / (strs?.get(5).toString()).toFloat()
//
//                var diff = calc_day(strs?.get(1).toString(), k)
//                editor.putString(k, k + ","
//                        + strs?.get(1).toString() + ","
//                        + strs?.get(2).toString() + ","
//                        + strs?.get(3).toString() + ","
//                        + strs?.get(4).toString() + "," + strs?.get(5).toString())
//                //editor.clear()
//                editor.commit()
//
//                //de habda
//                var habda: String = "false"
//                var data_back_days: SharedPreferences = getSharedPreferences("shareddays", 0)
//                //bashof ana f yom gded wlla la2
//                if (data_back_days.getString("lastday", "not found ") != "true") {
//                    Log.d("conditioncheck", "true")
//                    habda = strs?.get(4).toString()
//                } else {
//
//                }
//                //5alas keda
//
//                //endhabda
//                if (diff > strs?.get(5).toString().toInt()) {
//                    diff = strs?.get(5).toString().toLong()
//                    habda = "true"
//                }
//                //end habda gdeda
//
//                totalsum += strs?.get(2).toString().toInt()
//                totalrating += rating
//
//
//                var thename: String = "أيام"
//                if (k == "صيام الخميس" || k == "صيام الاثنين" || k == "صلاة الجمعة علي وقتها")
//                    thename = "أسبوع"
//
//                mycard.add(dataHabits(strs?.get(0).toString(), R.drawable.red, R.drawable.pink
//                        , R.drawable.coin, strs?.get(2).toString(), diff.toString() + "/" + strs?.get(5).toString()
//                        , rating, habda.toBoolean(), thename))
//                // }
//            }
//        } else {
//            tanshet.visibility = View.INVISIBLE
//            deleteall_but.visibility = View.INVISIBLE
//        }
//        //end habd gded --------------------
//
//        total2.text = totalsum.toString()
//
//        var tot = totalnum*5f
//        var progress = ((totalrating/tot) *100).toInt()
//
//        Log.d("tot" , tot.toString())
//        Log.d("totalrating" , totalrating.toInt().toString())
//
//        progressBar2.progress = progress
//        percentage.text = progress.toString()
//
//        hs1_recycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
//
//        hs1_recycler.adapter = mainAdapter(mycard, this, startdate,total2 , totalrating, totalnum, "mychallenges",progressBar2,percentage)
       }


        var databack = getSharedPreferences("shared", 0)
        var databack1 = getSharedPreferences("keyshared", 0) // to get back the keys


        //the recyclerview
        var m: MutableMap<String, String>
        m = databack.all as MutableMap<String, String>

        var keys: MutableMap<String, String> = databack1.all as MutableMap<String, String>
        Log.d("el keys", keys.toString())

        Log.d("checked is ", MyApplication.checked.toString())
        val thestring: String? = keys["keys"]
        var tempsize = 0
        var temp = ""

        if (thestring != null) {
            if (thestring.length > 0)
                temp = thestring.substring(0, thestring.length - 1)
        }

        val valuesinOrder = temp.split(",").toTypedArray()

        var totalsum = 0
        var totalrating = 0f
        var totalnum = valuesinOrder.size
        if (m.isNotEmpty()) {
            for (k in valuesinOrder) {

                val strs = m[k]?.split(",")?.toTypedArray()

                startdate = strs?.get(1).toString()

                var rating = (strs?.get(2).toString() + "f").toFloat() / (strs?.get(5).toString()).toFloat()

                var diff = calc_day(strs?.get(1).toString(), k)
                editor.putString(k, k + ","
                        + strs?.get(1).toString() + ","
                        + strs?.get(2).toString() + ","
                        + strs?.get(3).toString() + ","
                        + strs?.get(4).toString() + "," + strs?.get(5).toString())
                //editor.clear()
                editor.commit()

                //de habda
                var habda: String = "false"
                var data_back_days: SharedPreferences = getSharedPreferences("shareddays", 0)
                if (data_back_days.getString("lastday", "not found ") != "true") {
                    Log.d("conditioncheck", "true")
                    habda = strs?.get(4).toString()
                }
                //endhabda

                //habda gdedA
                if (diff > strs?.get(5).toString().toInt()) {
                    diff = strs?.get(5).toString().toLong()
                    habda = "true"
                }
                //end habda gdeda

                totalsum += strs?.get(2).toString().toInt()
                totalrating += rating

                var thename: String = "أيام"
                if (k == "صيام الخميس" || k == "صيام الاثنين" || k == "صلاة الجمعة علي وقتها")
                    thename = "أسبوع"

                mycards.add(HabitsData(strs?.get(0).toString(), R.drawable.red, R.drawable.pink
                        , R.drawable.coin, strs?.get(2).toString(), diff.toString() + "/" + strs?.get(5).toString()
                        , rating, habda.toBoolean(), thename))
                // }
            }
        } else {

            tanshet.visibility = View.INVISIBLE
            activityEngazatDeleteAllEngazatButton.visibility = View.INVISIBLE
        }


        total2.text = totalsum.toString()

        var tot = totalnum*5f
        var progress = ((totalrating/tot) *100).toInt()

        progressBar2.progress = progress
        percentage.text = progress.toString()

        hs1_recycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        hs1_recycler.adapter = MainAdapter(mycards, this, startdate,total2 ,totalrating, totalnum, "mychallenges",progressBar2,percentage)

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(hs1_recycler)

        //notification


    }

    /****************************************/

    val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {


        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            //some 3ak

            val builder = AlertDialog.Builder(this@MyChallengesActivity)
            builder.setTitle("مسح التحدي؟")
            builder.setMessage("هل ترغب بمسح هذا التحدي ؟")
            builder.setPositiveButton("نعم", { dialogInterface, i -> clearElement(viewHolder as MainAdapter.ViewHolder,"") })
            builder.setNegativeButton("لا", { dialogInterface, i -> refresh() })
            builder.setNeutralButton("إضافة إلي انجازاتي", { dialogInterface, i -> clearElement(viewHolder as MainAdapter.ViewHolder,"addengaz") })
            builder.show()


            /*myshared = getSharedPreferences("shared" , 0)
            var editor: SharedPreferences.Editor = myshared!!.edit()
            MyApplication.globalvar?.remove(mycards[viewHolder.adapterPosition].name)
            editor.remove(mycards[viewHolder.adapterPosition].name)
            editor.commit()
            Log.d("removed item" , MyApplication.keyname.toString())
            //end some 3ak
            (hs_recycler.adapter as mainAdapter).removeItem(viewHolder)*/
        }

    }


    /********************************************************************************/
//To add the card in engaz activity and remove it from the home screen
    private fun add_engaz(viewHolder: MainAdapter.ViewHolder) {

        /***********************Frist we need to save the state to shared preferences*******/
        //saveSharedpref()
        // refresh()

        //Adding logic
        var myshared_engaz = getSharedPreferences("shared_engaz", 0)

        var myshared1_engaz = getSharedPreferences("keyshared_engaz", 0)

        var editor_engaz: SharedPreferences.Editor = myshared_engaz!!.edit()
        var editor1_engaz: SharedPreferences.Editor = myshared1_engaz!!.edit()

        var card = mycards[viewHolder.adapterPosition] //card to be added in engazat
        Log.d("you", card.name.toString())

        var databack = getSharedPreferences("shared", 0)
        var databack1 = getSharedPreferences("keyshared", 0)

        var last_num = (myshared_engaz.all.size + 1).toString()  // store the keys of engazat as 1,2,3,4 .....


        var v = databack.getString(card.name, "toz")

        val strs = v?.split(",")?.toTypedArray()
        Log.d("array:", strs?.get(0).toString())

       var diff = calc_day(strs?.get(1).toString(), card.name)

        Log.d("numcoinsandrating", v.toString())

        //hena 8yart
        editor_engaz.putString(last_num, card.name + "," + strs?.get(2).toString() + "," + diff + '/' + strs?.get(5).toString()
                + "," + strs?.get(3).toString())
        editor_engaz.commit()

        var temp = getdataback_slicedform("keyshared_engaz")
        if (temp == null)
            temp = last_num + ","
        else temp = temp + last_num + ","
        editor1_engaz.putString("keys", temp)
        editor1_engaz.commit()


        //Removing logic


//        myshared = getSharedPreferences("shared", 0)
//        var editor: SharedPreferences.Editor = myshared!!.edit()
//
//        var myshared1 = getSharedPreferences("keyshared", 0)
//        var editor1: SharedPreferences.Editor = myshared1!!.edit()
//        //  MyApplication.globalvar?.remove(mycards[viewHolder.adapterPosition].name)
//        editor.remove(mycards[viewHolder.adapterPosition].name)
//        editor.commit()
//
//        var value = myshared1.getString("keys", "not ofun")
//        Log.d("valueBefore", value)
//
//        //var l=mycards[viewHolder.adapterPosition].name+","
//        var newvalue: String = isSubstring(mycards[viewHolder.adapterPosition].name, value.toString())
//
//        Log.d("newvalue", newvalue)
//
//        editor1.putString("keys", newvalue)
//        editor1.commit()
//        // Log.d("editor1",editor1.toString())
//        //end some 3ak
//        (hs1_recycler.adapter as mainAdapter).removeItem(viewHolder)


    }

    /*********************************************************************************************/

    fun getdataback_slicedform(s: String): String? {
        var databack = getSharedPreferences(s, 0)
        var m: MutableMap<String, String>
        m = databack.all as MutableMap<String, String>

        var keys: MutableMap<String, String> = databack.all as MutableMap<String, String>

        val thestring: String? = keys["keys"]
        return thestring
        /*val temp = thestring?.substring(0,thestring.len1gth-1)
        val valuesinOrder = temp?.split(",")?.toTypedArray()
        return valuesinOrder*/
    }


    fun newDay_remove_check() {
        myshared = getSharedPreferences("shareddays", 0)
        var data_back: SharedPreferences = getSharedPreferences("shareddays", 0)

        var editor: SharedPreferences.Editor = myshared!!.edit()
        val currdate: String = get_correct_format(java.util.Calendar.getInstance().time.toString())
        var day = currdate.split(" ").toTypedArray()

        Log.d("day in remove", day[0])
        //Log.d("lasday", data_back.getString("lastday", "bs b21a"))

        var m: MutableMap<String, String>
        m = data_back.all as MutableMap<String, String>
        editor.putString("lastday", "false")
        editor.commit()

        if ((data_back.getString("newday", "notfound") != day[0])) {


            editor.putString("newday", day[0])
            editor.putString("lastday", "true")
            editor.commit()

            //law el yom gded e3ml save lel shared pref enno unchecked
            /*********************************************/
            var myshared2: SharedPreferences = getSharedPreferences("shared", 0)


            var editorr: SharedPreferences.Editor = myshared2.edit()
            var databack = getSharedPreferences("shared", 0)


            var m: MutableMap<String, String>
            m = databack.all as MutableMap<String, String>

            if (m.isNotEmpty()) {
                for ((k, v) in m) {

                    val strs = m[k]?.split(",")?.toTypedArray()

                    editorr.putString(k, k + ","
                            + strs?.get(1).toString() + ","
                            + strs?.get(2).toString() + ","
                            + strs?.get(3).toString() + ","
                            + "false" + "," + strs?.get(5).toString())
                    //editor.clear()
                    editorr.commit()
                }
            }

            /********************************************/
        } else {
            editor.putString("lastday", "false")
            editor.commit()
        }

    }


    //function convert el format el s3b lel fromat el sahl
    fun get_correct_format(s: String): String {
        var m: MutableMap<String, String> = mutableMapOf("Jan" to "01", "Feb" to "02", "Mar" to "03",
                "Apr" to "04", "May" to "05", "Jun" to "06", "Jul" to "07", "Aug" to "08", "Sep" to "09",
                "Oct" to "10", "Nov" to "11", "Dec" to "12")
        var temp = s.split(" ").toTypedArray()
        var res: String = ""
        // Log.d("temp[2]" , temp[2])
        res += temp[2] + " " + m[temp[1]] + " " + temp[temp.size - 1]
        return res

    }


    //fun
     fun  calc_day(startdate_String: String, name: String): Long {
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

    fun clearAll() {
        myshared = getSharedPreferences("keyshared", 0)
        var editor1: SharedPreferences.Editor = myshared!!.edit()
        myshared = getSharedPreferences("shared", 0)
        var editor: SharedPreferences.Editor = myshared!!.edit()
        editor.clear()
        editor.commit()
        editor1.clear()
        editor1.commit()
        MyApplication.checked = 0
        MyApplication.globalvar = null
        MyApplication.keyname = ""

        val mycards = ArrayList<HabitsData>()
        hs1_recycler.adapter = MainAdapter(mycards, this, "",total2 , 0f ,0, "mychallenges",progressBar2,percentage)

        //make button and text invisible

        tanshet.visibility = View.INVISIBLE
        activityEngazatDeleteAllEngazatButton.visibility = View.INVISIBLE
        progressBar2.progress = 0
        percentage.text = "0 %"
    }


    fun clearElement(viewHolder: MainAdapter.ViewHolder, name:String)
    {


        myshared = getSharedPreferences("shared", 0)
        var editor: SharedPreferences.Editor = myshared!!.edit()

        var myshared1 = getSharedPreferences("keyshared", 0)
        var editor1: SharedPreferences.Editor = myshared1!!.edit()
        //  MyApplication.globalvar?.remove(mycards[viewHolder.adapterPosition].name);

        Log.d("removing" , mycards[viewHolder.adapterPosition].name)
        //editor.remove(mycards[viewHolder.adapterPosition].name)
        //editor.commit()

        var value = myshared1.getString("keys", "not ofun")
        //Log.d("valueBefore", value)

        //var l=mycards[viewHolder.adapterPosition].name+","
        var newvalue: String = isSubstring(mycards[viewHolder.adapterPosition].name, value.toString())

        Log.d("valuenew", newvalue)

        editor1.putString("keys", newvalue)
        editor1.commit()
        // Log.d("editor1",editor1.toString())
        //end some 3ak
        (hs1_recycler.adapter as MainAdapter).removeItem(viewHolder , name)
        //reload()
    }

    fun refresh() {
        val mycard_refresh = ArrayList<HabitsData>()


        // newDay_remove_check()
        myshared = getSharedPreferences("shared", 0)
        var editor: SharedPreferences.Editor = myshared!!.edit()
        var startdate: String = " "
        newDay_remove_check()


        //habd gded----------------------------------------
        //newDay_remove_check()
        var databack = getSharedPreferences("shared", 0)
        var databack1 = getSharedPreferences("keyshared", 0) // to get back the keys


        //the recyclerview
        var m: MutableMap<String, String>
        m = databack.all as MutableMap<String, String>

        var keys: MutableMap<String, String> = databack1.all as MutableMap<String, String>
        Log.d("el keys", keys.toString())

        Log.d("checked is ", MyApplication.checked.toString())
        val thestring: String? = keys["keys"]
        val temp = thestring?.substring(0, thestring.length - 1)
        val valuesinOrder = temp?.split(",")?.toTypedArray()
        Log.d("ydenela", valuesinOrder?.get(0).toString())

        var totalsum = 0
        var totalrating = 0f
        var totalnum = valuesinOrder?.size
        if (m.isNotEmpty()) {
            for (k in valuesinOrder!!) {

                val strs = m[k]?.split(",")?.toTypedArray()
                startdate = strs?.get(1).toString()

                var rating = (strs?.get(2).toString() + "f").toFloat() / (strs?.get(5).toString()).toFloat()

                var diff = calc_day(strs?.get(1).toString(), k)
                editor.putString(k, k + ","
                        + strs?.get(1).toString() + ","
                        + strs?.get(2).toString() + ","
                        + strs?.get(3).toString() + ","
                        + strs?.get(4).toString() + "," + strs?.get(5).toString())
                //editor.clear()
                editor.commit()

                //de habda
                var habda: String = "false"
                var data_back_days: SharedPreferences = getSharedPreferences("shareddays", 0)
                if (data_back_days.getString("lastday", "not found ") != "true") {
                    Log.d("conditioncheck", "true")
                    habda = strs?.get(4).toString()
                }

                //endhabda
                if (diff > strs?.get(5).toString().toInt()) {
                    diff = strs?.get(5).toString().toLong()
                    habda = "true"
                }
                //end habda gdeda

                totalsum += strs?.get(2).toString().toInt()
                totalrating += rating

                var thename: String = "أيام"
                if (k == "صيام الخميس" || k == "صيام الاثنين" || k == "صلاة الجمعة علي وقتها")
                    thename = "أسبوع"

                mycard_refresh.add(HabitsData(strs?.get(0).toString(), R.drawable.red, R.drawable.pink
                        , R.drawable.coin, strs?.get(2).toString(), diff.toString() + "/" + strs?.get(5).toString()
                        , rating, habda.toBoolean(), thename))
                // }
            }
        }
        //end habd gded --------------------
        total2.text = totalsum.toString()

        var tot = totalnum?.times(5f)
        var progress = ((totalrating/ tot!!) *100).toInt()

        progressBar2.progress = progress
        percentage.text = progress.toString()

        hs1_recycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        hs1_recycler.adapter = MainAdapter(mycard_refresh, this, startdate , total2 ,totalrating, totalnum!!, "mychallenges",progressBar2,percentage)
    }

    //to remove a substring from given string
    fun removesubstring(s: String, sub: String): String {
        var res: String = ""
        for (i in s.indices) {
            if (s[i] == sub[0]) {
                res = s.removeRange(i, i + sub.length)
            }
        }
        return res
    }


    fun isSubstring(word: String, keys: String): String {
        //first: split the keys to array
        val strs = keys.split(",").toTypedArray()

        //second: find the matching key
        var idx: Int = 0
        for (i in 0..strs.size-1) {
            if (word == strs[i]) {
                idx = i
                break
            }
        }

        //rebuild the string ignoring the matching key
        var finalkeys = ""
        for (i in 0..strs.size-1) {
            if (i != idx && strs[i]!= "") {
                finalkeys += strs[i] + ','
            }
        }

        Log.d("valueb", keys)
        Log.d("valueafter", finalkeys)
        return finalkeys
    }



//        val M = s1.length //to be cut
//        val N = s2.length// all keys
//
//        /* A loop to slide pat[] one by one */
//        var idx: Int = 0
//        for (i in 0..N - M) {
//            var j: Int
//
//            /* For current index i, check for
//            pattern match */
//            j = 0
//            while (j < M) {
//                if (s2[i + j] != s1[j])
//                    break
//                j++
//            }
//
//            if (j == M)
//                idx = i
//        }
//        return s2.removeRange(idx, idx + s1.length)

 //  }
    /*****************very very very strong noitification part habd******************/


    /*****************end*****************************************/

    fun omar(notificationId: Int) {

        var notification_manager: NotificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        var chanel_id: String = "3000"
        var name: CharSequence = "Channel Name"
        var description: String = "Chanel Description"
        var importance: Int = NotificationManager.IMPORTANCE_LOW
        var notification_builder = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var mChannel: NotificationChannel = NotificationChannel(chanel_id, name, importance)
            mChannel.description = description
            mChannel.enableLights(true)
            mChannel.lightColor = Color.BLUE
            notification_manager.createNotificationChannel(mChannel)
            var notification_builder = NotificationCompat.Builder(this, chanel_id)


            val intent = Intent(this, MainActivity::class.java)
            val activity = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)


            notification_builder.setSmallIcon(R.drawable.mosq)
                    .setContentTitle("لنواصل السير الي الله")
                    .setContentText("استعن بالله ولا تعجز...لا تحقرن صغيرة إن الجبال من الحصا!")
                    .setAutoCancel(true)
                    .setContentIntent(activity)


            notification_builder.setContentIntent(activity)

            //
            var nm: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nm.notify(51, notification_builder.build())


            val notification = notification_builder.build()

            val notificationIntent = Intent(this, MyNotificationPublisher::class.java)
            notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION_ID, notificationId)
            notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION, notification)
            val pendingIntent = PendingIntent.getBroadcast(this, notificationId, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT)

            //val futureInMillis = SystemClock.elapsedRealtime() + 5000 //12 hours
            // val futureInMillis:Long = java.lang.System.currentTimeMillis() + 1000//12 hours
            // Log.d("ellee7namsh3rfeno" , futureInMillis.toString())
            val alarmManager = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            //alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent)
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, java.lang.System.currentTimeMillis(), 1000 * 60 * 60 * 24, pendingIntent)

        } else {
            var notification_builder = NotificationCompat.Builder(this)
            val intent = Intent(this, MainActivity::class.java)
            val activity = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)


            notification_builder.setSmallIcon(R.drawable.mosq)
                    .setContentTitle("لنواصل السير إلي الله")
                    .setContentText("استعن بالله ولا تعجز...لا تحقرن صغيرة إن الجبال من الحصا!")
                    .setAutoCancel(true)
                    .setContentIntent(activity)


            notification_builder.setContentIntent(activity)

            //
            var nm: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nm.notify(51, notification_builder.build())


            val notification = notification_builder.build()

            val notificationIntent = Intent(this, MyNotificationPublisher::class.java)
            notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION_ID, notificationId)
            notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION, notification)
            val pendingIntent = PendingIntent.getBroadcast(this, notificationId, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT)

            // val futureInMillis = SystemClock.elapsedRealtime() + delay
            val alarmManager = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, java.lang.System.currentTimeMillis(), 1000 * 60 * 60 * 24, pendingIntent)
        }


    }


    /*****************end*****************************************/

    fun saveSharedpref() {
        /************************refreshing****************************/

        Log.d("bt7tam", "ama nshof")
        var startdate: String = " "
        mycards.clear()

        //habd new
        myshared = getSharedPreferences("shared", 0)
        var editor = myshared!!.edit()
        var databack = getSharedPreferences("shared", 0)
        var databack1 = getSharedPreferences("keyshared", 0) // to get back the keys


        //the recyclerview
        var m: MutableMap<String, String>
        m = databack.all as MutableMap<String, String>

        var keys: MutableMap<String, String> = databack1.all as MutableMap<String, String>
        Log.d("el keys", keys.toString())

        Log.d("checked is ", MyApplication.checked.toString())
        var thestring: String? = keys["keys"]

        var tempsize = 0

        var temp = ""

        if (thestring != null) {
            if (thestring.length > 0)
                temp = thestring.substring(0, thestring.length - 1)
        }

        var valuesinOrder = temp.split(",").toTypedArray()

        for (i in valuesinOrder)
            Log.d("ydenela", i)
        //var data_back1:SharedPreferences =getSharedPreferences("shared" , 0)
        //keys = data_back1.all as MutableMap<String, String> // to get all shared variables
        //var v:Array<String> = arrayOf("الصلاوات الخمس","صيام رمضان")
        // var rating:Float
        if (m.isNotEmpty()) {
            for (k in valuesinOrder) {

                val strs = m[k]?.split(",")?.toTypedArray()
                Log.d("elmapa",m[k].toString())
                startdate = strs?.get(1).toString()

                var rating = (strs?.get(2).toString() + "f").toFloat() / (strs?.get(5).toString()).toFloat()

                var diff = calc_day(strs?.get(1).toString(), k)
                editor.putString(k, k + ","
                        + strs?.get(1).toString() + ","
                        + strs?.get(2).toString() + ","
                        + strs?.get(3).toString() + ","
                        + strs?.get(4).toString() + "," + strs?.get(5).toString())
                //editor.clear()
                editor.commit()

                //de habda
                var habda: String = "false"
                var data_back_days: SharedPreferences = getSharedPreferences("shareddays", 0)
                if (data_back_days.getString("lastday", "not found ") != "true") {
                    Log.d("conditioncheck", "true")
                    habda = strs?.get(4).toString()
                }
                //endhabda

                //habda gdedA
                if (diff > strs?.get(5).toString().toInt()) {
                    diff = strs?.get(5).toString().toLong()
                    habda = "true"
                }
                //end habda gdeda

                var thename: String = "أيام"
                if (k == "صيام الخميس" || k == "صيام الاثنين" || k == "صلاة الجمعة علي وقتها")
                    thename = "أسبوع"

                mycards.add(HabitsData(strs?.get(0).toString(), R.drawable.red, R.drawable.pink
                        , R.drawable.coin, strs?.get(2).toString(), diff.toString() + "/" + strs?.get(5).toString()
                        , rating, habda.toBoolean(), thename))
                // }
            }
        }


        /***********************************************************/

        //end habd gded --------------------


    }

    fun reload() {


        newDay_remove_check()

        var startdate: String = " "
        var mycart = arrayListOf<HabitsData>()

        //habd new
        myshared = getSharedPreferences("shared", 0)
        var editor = myshared!!.edit()
        var databack = getSharedPreferences("shared", 0)
        var databack1 = getSharedPreferences("keyshared", 0) // to get back the keys


        //the recyclerview
        var m: MutableMap<String, String>
        m = databack.all as MutableMap<String, String>

        var keys: MutableMap<String, String> = databack1.all as MutableMap<String, String>
        Log.d("el keys", keys.toString())

        Log.d("checked is ", MyApplication.checked.toString())
        var thestring: String? = keys["keys"]

        var tempsize = 0

        var temp = ""

        if (thestring != null) {
            if (thestring.length > 0)
                temp = thestring.substring(0, thestring.length - 1)
        }

        var valuesinOrder = temp.split(",").toTypedArray()
        //Log.d("ydenela", valuesinOrder?.get(0).toString())
        //var data_back1:SharedPreferences =getSharedPreferences("shared" , 0)
        //keys = data_back1.all as MutableMap<String, String> // to get all shared variables
        //var v:Array<String> = arrayOf("الصلاوات الخمس","صيام رمضان")
        // var rating:Float

        var totalsum = 0
        var totalrating = 0f
        var totalnum = valuesinOrder.size
        if (m.isNotEmpty()) {
            for (k in valuesinOrder) {

                val strs = m[k]?.split(",")?.toTypedArray()
                startdate = strs?.get(1).toString()

                var rating = (strs?.get(2).toString() + "f").toFloat() / (strs?.get(5).toString()).toFloat()

                var diff = calc_day(strs?.get(1).toString(), k)
                editor.putString(k, k + ","
                        + strs?.get(1).toString() + ","
                        + strs?.get(2).toString() + ","
                        + strs?.get(3).toString() + ","
                        + strs?.get(4).toString() + "," + strs?.get(5).toString())
                //editor.clear()
                editor.commit()

                //de habda
                var habda: String = "false"
                var data_back_days: SharedPreferences = getSharedPreferences("shareddays", 0)
                //bashof ana f yom gded wlla la2
                if (data_back_days.getString("lastday", "not found ") != "true") {
                    Log.d("conditioncheck", "true")
                    habda = strs?.get(4).toString()
                } else {

                }
                //5alas keda

                //endhabda
                if (diff > strs?.get(5).toString().toInt()) {
                    diff = strs?.get(5).toString().toLong()
                    habda = "true"
                }
                //end habda gdeda
                //end habda gdeda

                totalsum += strs?.get(2).toString().toInt()
                totalrating += rating
                var thename: String = "أيام"
                if (k == "صيام الخميس" || k == "صيام الاثنين" || k == "صلاة الجمعة علي وقتها")
                    thename = "أسبوع"

                mycart.add(HabitsData(strs?.get(0).toString(), R.drawable.red, R.drawable.pink
                        , R.drawable.coin, strs?.get(2).toString(), diff.toString() + "/" + strs?.get(5).toString()
                        , rating, habda.toBoolean(), thename))
                // }
            }

        } else {

            tanshet.visibility = View.INVISIBLE
            activityEngazatDeleteAllEngazatButton.visibility = View.INVISIBLE
        }

        total2.text = totalsum.toString()

        var tot = totalnum*5f
        var progress = ((totalrating/tot) *100).toInt()

        progressBar2.progress = progress
        percentage.text = progress.toString()
        hs1_recycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        hs1_recycler.adapter = MainAdapter(mycart, this, startdate,total2,totalrating , totalnum , "mychallenges",progressBar2,percentage)
    }


}

