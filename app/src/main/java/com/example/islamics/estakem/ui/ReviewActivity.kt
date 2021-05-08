package com.example.islamics.estakem.ui

import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.islamics.estakem.R
import kotlinx.android.synthetic.main.activity_review.*

class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)
        fun Double.format(digits: Int) = "%.${digits}f".format(this)
        var nameinrev:String? = intent.extras.getString("fareda_name")
        var coinsinrev:String? = intent.extras.getString("fareda_numofcoins")
        var daysinrev:String? = intent.extras.getString("fareda_numdays")
        var ratinginrev:String? = intent.extras.getString("fareda_rating")
        var numdays_separated=daysinrev?.split("/")?.toTypedArray()

        var new_progress:Float = (coinsinrev.toString()+"f").toFloat()/ ((numdays_separated?.get(1)).toString().toFloat())
        Log.d("new_progress",new_progress.toString())

        var progress:Float=0.0f
        progress=((new_progress) / "5f".toFloat())*100
        var progress_as_int=progress.toInt()
        progressBar.progress=progress.toInt()
        //percent.text=progress.format(1).toString()+"%"
        percent.text = progress_as_int.toString()+" %"

        name.text=nameinrev
        var num_of_checked_days=coinsinrev.toString().toInt()/5
        myvalue.text=num_of_checked_days.toString()+" /"

        if(nameinrev == "صيام الخميس" || nameinrev == "صيام الاثنين" || nameinrev == "صلاة الجمعة علي وقتها")
            total.text = "أسبوع   "+(numdays_separated?.get(1))
        else total.text = "أيام   "+(numdays_separated?.get(1))

                // el kalam elle hytketeb
        if(progress_as_int < 75 )
        {
            tkyem.setTextColor(Color.YELLOW)
            review.setTextColor(Color.YELLOW)
            tkyem.text = " مثابر !"
            review.text = "أنت مثابر! و قد بدأت خطوات قوية في طريقك إلى الله ... ولكن تحتاج إلى المزيد من المثابرة حتي تصل إلى هدفك و غايتك ..... الجنة"
        }
        else
        {
            tkyem.setTextColor(Color.GREEN)
            review.setTextColor(Color.GREEN)
            tkyem.text = "بطل !"
            review.text = "أنت بطل ! و صاحب عزيمة قوية ! و قد حققت مرادك من هذا التحدي ، و اعلم أخي أن هذه ليست نهاية طريقك إلى الله ، وقد بدأت بأخذ خطوات ثابتة لتكون من عباد الله المقربين المخلصين ...اسأل الله ان تكون من أهل الفردوس الأعلي من الجنة و أن يجمعك مع نبيه المصطفي صلي الله عليه و سلم"
        }




    }
    fun Float.format(digits: Int) = "%.${digits}f".format(this)

}


