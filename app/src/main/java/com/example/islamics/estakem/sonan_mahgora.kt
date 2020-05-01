package com.example.islamics.estakem

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_sonan_mahgora.*

class sonan_mahgora : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonan_mahgora)
        // data of frayed
        val frayed = ArrayList<data_farayed>()
        frayed.add( data_farayed("الصلاوات الخمس" ,R.drawable.mosq, R.drawable.red,R.drawable.red))
        frayed.add( data_farayed("صيام رمضان" ,R.drawable.fanos, R.drawable.yellow,R.drawable.yellow))
        frayed.add( data_farayed("طلب العلم" ,R.drawable.book1, R.drawable.blue,R.drawable.blue))
        frayed.add( data_farayed("بر الوالدين" ,R.drawable.parent, R.drawable.pink,R.drawable.pink))
        frayed.add( data_farayed("صلاة الجمعة علي وقتها" ,R.drawable.gomaa, R.drawable.green,R.drawable.green))

        // end datafrayed




        sonan_recycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        val adapter = customAdapter_frayed(frayed)
        sonan_recycler.adapter = adapter

    }
}
