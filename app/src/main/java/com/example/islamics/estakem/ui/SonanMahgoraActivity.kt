package com.example.islamics.estakem.ui

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.islamics.estakem.ui.adapter.FaraedCustomAdapter
import com.example.islamics.estakem.ui.data.FaraedData
import com.example.islamics.estakem.R
import kotlinx.android.synthetic.main.activity_sonan_mahgora.*

class SonanMahgoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonan_mahgora)
        // data of frayed
        val frayed = ArrayList<FaraedData>()
        frayed.add( FaraedData("الصلاوات الخمس" , R.drawable.mosq, R.drawable.red, R.drawable.red))
        frayed.add( FaraedData("صيام رمضان" , R.drawable.fanos, R.drawable.yellow, R.drawable.yellow))
        frayed.add( FaraedData("طلب العلم" , R.drawable.book1, R.drawable.blue, R.drawable.blue))
        frayed.add( FaraedData("بر الوالدين" , R.drawable.parent, R.drawable.pink, R.drawable.pink))
        frayed.add( FaraedData("صلاة الجمعة علي وقتها" , R.drawable.gomaa, R.drawable.green, R.drawable.green))

        // end datafrayed




        sonan_recycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        val adapter = FaraedCustomAdapter(frayed)
        sonan_recycler.adapter = adapter

    }
}
