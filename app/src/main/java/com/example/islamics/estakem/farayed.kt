package com.example.islamics.estakem

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_farayed.*

class farayed : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farayed)
        //var my = MyApplication()
        Log.d("check in frayed",MyApplication.checked.toString())
        // data of frayed
        val frayed = ArrayList<data_farayed>()
        val elname: String? = intent.extras?.getString("name")
        Log.d("esm el button",elname)

        //controls what to display in recycler view with respect to the button clicked

        if(elname == "farayed")
        {
            frayed.add(data_farayed("الصلاوات الخمس", R.drawable.mosq, R.drawable.red, R.drawable.red))
            frayed.add(data_farayed("صيام رمضان", R.drawable.fanos, R.drawable.yellow, R.drawable.yellow))
            frayed.add(data_farayed("طلب العلم", R.drawable.book1, R.drawable.blue, R.drawable.blue))
            frayed.add(data_farayed("بر الوالدين", R.drawable.parent, R.drawable.pink, R.drawable.pink))
            frayed.add(data_farayed("قراءة القرآن" , R.drawable.quraan, R.drawable.yellow, R.drawable.yellow))
            frayed.add(data_farayed("صلاة الجمعة علي وقتها", R.drawable.gomaa, R.drawable.blue, R.drawable.blue))
            frayed.add(data_farayed("الزكاة" , R.drawable.zakat, R.drawable.green, R.drawable.green))
            frayed.add(data_farayed("صلة الأرحام" , R.drawable.family, R.drawable.red, R.drawable.red))
            // end datafrayed
        }
        else if (elname == "nwafel")
        {
            frayed.add(data_farayed("السنن الرواتب", R.drawable.prophet2, R.drawable.red, R.drawable.red))
            frayed.add(data_farayed("قيام الليل", R.drawable.prophet2, R.drawable.yellow, R.drawable.yellow))
            frayed.add(data_farayed("الضحى", R.drawable.prophet2, R.drawable.blue, R.drawable.blue))
            frayed.add(data_farayed("التراويح فى رمضان", R.drawable.prophet2, R.drawable.pink, R.drawable.pink))
            frayed.add(data_farayed("صيام العشر من ذى الحجة", R.drawable.prophet2, R.drawable.green, R.drawable.green))
            frayed.add(data_farayed("صيام الايام البيض", R.drawable.prophet2, R.drawable.red, R.drawable.red))
            frayed.add(data_farayed("صيام الاثنين", R.drawable.prophet2, R.drawable.yellow, R.drawable.yellow))
            frayed.add(data_farayed("صيام الخميس", R.drawable.prophet2, R.drawable.yellow, R.drawable.yellow))
            frayed.add(data_farayed("الصدقات", R.drawable.prophet2,R.drawable.blue, R.drawable.blue))
            frayed.add(data_farayed("صلاتي الشفع و الوتر", R.drawable.prophet2,R.drawable.pink, R.drawable.pink))
            frayed.add(data_farayed("صلاة تحية المسجد", R.drawable.prophet2, R.drawable.green, R.drawable.green))
            frayed.add(data_farayed("صيام يوم عرفه", R.drawable.prophet2, R.drawable.red, R.drawable.red))
            frayed.add(data_farayed("صيام يوم عاشوراء", R.drawable.prophet2, R.drawable.yellow, R.drawable.yellow))
            // end datafrayed
        }
        else
        {
            frayed.add(data_farayed("أن ينفض الفراش قبل النوم", R.drawable.prophet2, R.drawable.red, R.drawable.red))
            frayed.add(data_farayed("شرب الماء جالساً", R.drawable.prophet2,  R.drawable.yellow, R.drawable.yellow))
            frayed.add(data_farayed("البدء باليمين في لبس الملابس", R.drawable.prophet2,R.drawable.blue, R.drawable.blue))
            frayed.add(data_farayed("الاستغفار للوالدين", R.drawable.prophet2, R.drawable.pink, R.drawable.pink))
            frayed.add(data_farayed("الذكر الوارد بعد الوتر", R.drawable.prophet2, R.drawable.green, R.drawable.green))
            frayed.add(data_farayed("المضمضه والاستنشاق بكف واحده", R.drawable.prophet2, R.drawable.red, R.drawable.red))
            frayed.add(data_farayed("ملازمة السواك", R.drawable.prophet2,  R.drawable.yellow, R.drawable.yellow))
            frayed.add(data_farayed("محاسبة النفس", R.drawable.prophet2, R.drawable.blue, R.drawable.blue))
            frayed.add(data_farayed("صلاة الاستخارة", R.drawable.prophet2, R.drawable.pink, R.drawable.pink))
            frayed.add(data_farayed("اذكار الصباح و المساء", R.drawable.prophet2, R.drawable.green, R.drawable.green))
            frayed.add(data_farayed("الجلوس فى المصلى بعد الفجر", R.drawable.prophet2, R.drawable.red, R.drawable.red))


        }


        frayed_recycler.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        val adapter = customAdapter_frayed(frayed)
        frayed_recycler.adapter = adapter


    }
}
