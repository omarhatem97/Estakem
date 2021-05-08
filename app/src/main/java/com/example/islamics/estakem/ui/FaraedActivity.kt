package com.example.islamics.estakem.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import com.example.islamics.estakem.ui.adapter.FaraedCustomAdapter
import com.example.islamics.estakem.ui.data.FaraedData
import com.example.islamics.estakem.MyApplication
import com.example.islamics.estakem.R
import kotlinx.android.synthetic.main.activity_farayed.*

class FaraedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farayed)
        //var my = MyApplication()
        Log.d("check in frayed", MyApplication.checked.toString())
        // data of frayed
        val frayed = ArrayList<FaraedData>()
        val elname: String? = intent.extras?.getString("name")
        Log.d("esm el button",elname)

        //controls what to display in recycler view with respect to the button clicked

        if(elname == "farayed")
        {
            frayed.add(FaraedData("الصلاوات الخمس", R.drawable.mosq, R.drawable.red, R.drawable.red))
            frayed.add(FaraedData("صيام رمضان", R.drawable.fanos, R.drawable.yellow, R.drawable.yellow))
            frayed.add(FaraedData("طلب العلم", R.drawable.book1, R.drawable.blue, R.drawable.blue))
            frayed.add(FaraedData("بر الوالدين", R.drawable.parent, R.drawable.pink, R.drawable.pink))
            frayed.add(FaraedData("قراءة القرآن" , R.drawable.quraan, R.drawable.yellow, R.drawable.yellow))
            frayed.add(FaraedData("صلاة الجمعة علي وقتها", R.drawable.gomaa, R.drawable.blue, R.drawable.blue))
            frayed.add(FaraedData("الزكاة" , R.drawable.zakat, R.drawable.green, R.drawable.green))
            frayed.add(FaraedData("صلة الأرحام" , R.drawable.family, R.drawable.red, R.drawable.red))
            // end datafrayed
        }
        else if (elname == "nwafel")
        {
            frayed.add(FaraedData("السنن الرواتب", R.drawable.prophet2, R.drawable.red, R.drawable.red))
            frayed.add(FaraedData("قيام الليل", R.drawable.prophet2, R.drawable.yellow, R.drawable.yellow))
            frayed.add(FaraedData("الضحى", R.drawable.prophet2, R.drawable.blue, R.drawable.blue))
            frayed.add(FaraedData("التراويح فى رمضان", R.drawable.prophet2, R.drawable.pink, R.drawable.pink))
            frayed.add(FaraedData("صيام العشر من ذى الحجة", R.drawable.prophet2, R.drawable.green, R.drawable.green))
            frayed.add(FaraedData("صيام الايام البيض", R.drawable.prophet2, R.drawable.red, R.drawable.red))
            frayed.add(FaraedData("صيام الاثنين", R.drawable.prophet2, R.drawable.yellow, R.drawable.yellow))
            frayed.add(FaraedData("صيام الخميس", R.drawable.prophet2, R.drawable.yellow, R.drawable.yellow))
            frayed.add(FaraedData("الصدقات", R.drawable.prophet2, R.drawable.blue, R.drawable.blue))
            frayed.add(FaraedData("صلاتي الشفع و الوتر", R.drawable.prophet2, R.drawable.pink, R.drawable.pink))
            frayed.add(FaraedData("صلاة تحية المسجد", R.drawable.prophet2, R.drawable.green, R.drawable.green))
            frayed.add(FaraedData("صيام يوم عرفه", R.drawable.prophet2, R.drawable.red, R.drawable.red))
            frayed.add(FaraedData("صيام يوم عاشوراء", R.drawable.prophet2, R.drawable.yellow, R.drawable.yellow))
            // end datafrayed
        }
        else
        {
            frayed.add(FaraedData("أن ينفض الفراش قبل النوم", R.drawable.prophet2, R.drawable.red, R.drawable.red))
            frayed.add(FaraedData("شرب الماء جالساً", R.drawable.prophet2,  R.drawable.yellow, R.drawable.yellow))
            frayed.add(FaraedData("البدء باليمين في لبس الملابس", R.drawable.prophet2, R.drawable.blue, R.drawable.blue))
            frayed.add(FaraedData("الاستغفار للوالدين", R.drawable.prophet2, R.drawable.pink, R.drawable.pink))
            frayed.add(FaraedData("الذكر الوارد بعد الوتر", R.drawable.prophet2, R.drawable.green, R.drawable.green))
            frayed.add(FaraedData("المضمضه والاستنشاق بكف واحده", R.drawable.prophet2, R.drawable.red, R.drawable.red))
            frayed.add(FaraedData("ملازمة السواك", R.drawable.prophet2,  R.drawable.yellow, R.drawable.yellow))
            frayed.add(FaraedData("محاسبة النفس", R.drawable.prophet2, R.drawable.blue, R.drawable.blue))
            frayed.add(FaraedData("صلاة الاستخارة", R.drawable.prophet2, R.drawable.pink, R.drawable.pink))
            frayed.add(FaraedData("اذكار الصباح و المساء", R.drawable.prophet2, R.drawable.green, R.drawable.green))
            frayed.add(FaraedData("الجلوس فى المصلى بعد الفجر", R.drawable.prophet2, R.drawable.red, R.drawable.red))


        }


        frayed_recycler.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        val adapter = FaraedCustomAdapter(frayed)
        frayed_recycler.adapter = adapter


    }
}
