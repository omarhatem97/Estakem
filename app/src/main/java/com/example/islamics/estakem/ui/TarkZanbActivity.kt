package com.example.islamics.estakem.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.islamics.estakem.R
import kotlinx.android.synthetic.main.activity_tarkzanb.*


class TarkZanbActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarkzanb)
        var myshared:SharedPreferences
        var myshared1:SharedPreferences

        val elname_:String? = intent.extras?.getString("mystate")
       // Log.d("elnamebt3y" ,elname_)

        //displaying
        if(elname_ == "znb")
        {
            activityTarkZanbAyaBifaldillah.text = "قُلْ يَا عِبَادِيَ الَّذِينَ أَسْرَفُوا عَلَىٰ أَنفُسِهِمْ لَا تَقْنَطُوا مِن رَّحْمَةِ اللَّهِ ۚ إِنَّ اللَّهَ يَغْفِرُ الذُّنُوبَ جَمِيعًا ۚ إِنَّهُ هُوَ الْغَفُورُ الرَّحِيمُ "
            activityTarkZanbScrollViewText.text = "إن وقوع الإنسان في الذنوب أمر لا مفر منه، وهذه ليست مشكلة في حد ذاتها إنما المشكلة والمصيبة هي الاستمرار في الخطأ والإصرار على المعاصي، قال الغزاليّ: \"اعلم أنّ الصّغيرة تكبر بأسباب فيها الإصرار والمواظبة: وكذلك قيل: لا صغيرة مع إصرار، ولا كبيرة مع استغفار\"، فكيف إذا كان الإصرار على الكبائر وعدم التوبة منها؟! وقد وعد الله المستغفرين التائبين بالمغفرة والثواب العظيم فقال: { {وَالَّذِينَ إِذَا فَعَلُواْ فَاحِشَةً أَوْ ظَلَمُواْ أَنْفُسَهُمْ ذَكَرُواْ اللّهَ فَاسْتَغْفَرُواْ لِذُنُوبِهِمْ وَمَن يَغْفِرُ الذُّنُوبَ إِلاَّ اللّهُ وَلَمْ يُصِرُّواْ عَلَى مَا فَعَلُواْ وَهُمْ يَعْلَمُونَ * أُولَئِكَ جَزَاؤُهُمْ مَغْفِرَةٌ مِنْ رَبِّهِمْ وَجَنَّاتٌ تَجْرِي مِنْ تَحْتِهَا الْأَنْهَارُ خَالِدِينَ فِيهَا وَنِعْمَ أَجْرُ الْعَامِلِينَ}  }[آل عمران: 135-136]. وجاء في الحديث عن أبي هريرة رضي الله عنه أن النبي صلى الله عليه وسلم قال: (وَالَّذِي نَفْسِي بِيَدِهِ لَوْ لَمْ تُذْنِبُوا لَذَهَبَ اللَّهُ بِكُمْ وَلَجَاءَ بِقَوْمٍ يُذْنِبُونَ فَيَسْتَغْفِرُونَ اللَّهَ فَيَغْفِرُ لَهُمْ). وقد وضح النبي صلى الله عليه وسلم أن كل الناس يخطئون وأن خيرهم من يتوب إلى الله ويرجع إليه كلما حصل منه خطأ، كما في حديث أنس رضي الله عنه أن النبي صلى الله عليه وسلم قال: (كل بني آدم خطاء وخير الخطائين التوابون)، وليس المقصود من هذا أن الإنسان يقحم نفسه في الخطأ إقحاماً ويرتكب المنكرات ثم يقول: كلنا أصحاب خطأ وسنتوب! فيسوِّف هذا المسكين في التوبة وربما اخترمه الموت وهو على حاله السيئ! عياذا بالله. ففرق بين من هو غريق في الذنوب لغفلة ولطغيان ثم يفيق منها ويستغفر، وفرق بين من يصر على الذنوب والمعاصي وهو يعلم حرمتها وهو مع ذلك يتساهل في الاستمرار عليها، ولا يعجل بالتوبة. ولهذا جاء في الآية السابقة قول الله تعالى: {و {لم يصروا} } فجمع بين أمرين مهمين هنا وهما: سرعة الإفاقة من الذنب وسرعة الاستغفار قبل فوات الأوان، ويدل عليه الإتيان بالفاء (فاستغفروا) وهي تفيد الترتيب والتعقيب، يعني حصول الاستغفار مباشرة عقب الذنب، فلم يحصل من الشخص تمادٍ وإصرار، الأمر الثاني: قوله: (ولم يصروا) أي تابوا سريعاً ولم يتمادوا في الذنب. والإصرار على الصغائر من غير توبة أمر خطير قد يوصلها إلى كبائر الذنوب، فكيف بالإصرار على الكبائر؟ ولهذا جاء عن ابن عباس أنه قال: لا كبيرة مع استغفار، ولا صغيرة مع إصرار.  والله سبحانه يحب العبد التواب الأوَّاب الرجَّاع إليه في كل حين كما في قوله تعالى: {.. {إِنَّ اللّهَ يُحِبُّ التَّوَّابِينَ وَيُحِبُّ الْمُتَطَهِّرِينَ} }[البقرة: 222]. بل إن الله يفرح بتوبة العبد ورجوعه إليه واعترافه بذنبه، كما جاء في حديث أنس بن مالك رضي الله عنه أن النبي صلى الله عليه وسلم قال: ((لَلَّهُ أَشَدُّ فَرَحًا بِتَوْبَةِ عَبْدِهِ حِينَ يَتُوبُ إِلَيْهِ مِنْ أَحَدِكُمْ كَانَ عَلَى رَاحِلَتِهِ بِأَرْضِ فَلَاةٍ فَانْفَلَتَتْ مِنْهُ وَعَلَيْهَا طَعَامُهُ وَشَرَابُهُ فَأَيِسَ مِنْهَا فَأَتَى شَجَرَةً فَاضْطَجَعَ فِي ظِلِّهَا قَدْ أَيِسَ مِنْ رَاحِلَتِهِ فَبَيْنَا هُوَ كَذَلِكَ إِذَا هُوَ بِهَا قَائِمَةً عِنْدَهُ فَأَخَذَ بِخِطَامِهَا ثُمَّ قَالَ مِنْ شِدَّةِ الْفَرَحِ: اللَّهُمَّ أَنْتَ عَبْدِي وَأَنَا رَبُّكَ! أَخْطَأَ مِنْ شِدَّةِ الْفَرَحِ))"

        }
        if(elname_ == "mine"){
            //activityTarkZanbScrollView.visibility = View.INVISIBLE //todo check thid
            activityTarkZanbAyaBifaldillah.text = "فَإِذَا عَزَمْتَ فَتَوَكَّلْ عَلَى اللَّهِ ۚ إِنَّ اللَّهَ يُحِبُّ الْمُتَوَكِّلِينَ"
            activityTarkZanbScrollViewText.text = "استعن بالله و لا تعجز"
        }

        activityTarkZanbStartButton.setOnClickListener {
            myshared = getSharedPreferences("shared", 0)
            myshared1 = getSharedPreferences("keyshared", 0)

            var editor: SharedPreferences.Editor = myshared.edit()
            var editor1: SharedPreferences.Editor = myshared1.edit()



            //declaring initial variables
            var num_days_: String = activityTarkZanbActivityDaysNumEt.text.toString()
            var num_days:String = translate(num_days_)
            var s1: String = activityTarkZanbZanbName.text.toString()
            var startdate = java.util.Calendar.getInstance().time.toString()
            //    var day = LocalDateTime.now()
            // Log.d("currday" , startday)
            // var daypercentage:String = currday+" / " + num_days
            var numcoins: String = "0"
            var rating: Float = 0.0f
            var checkstate: String = "false"
            if (num_days_.isNotEmpty() && num_days.toIntOrNull() != null) {
                if (num_days.toInt() > 0) {
                    editor.putString(s1, s1 + "," + startdate + "," + numcoins + "," + rating.toString() + "," + "false"
                            + "," + num_days)


                    var temp = getdataback_slicedform("keyshared")
                    if (temp == null)
                        temp = s1 + ","
                    else temp = temp + s1 + ","
                    editor1.putString("keys", temp)
                    editor1.commit()


                    //editor.clear()
                    editor.commit()


                    val intent = Intent(this, MyChallengesActivity::class.java)
                    intent.putExtra("startdate", startdate)
                    startActivity(intent)


                }
            }

        }
    }

    fun getdataback_slicedform(s:String): String?
    {
        var databack =getSharedPreferences(s,0)
        var m: MutableMap<String,String>
        m = databack.all as MutableMap<String, String>

        var keys: MutableMap<String,String> = databack.all as MutableMap<String, String>

        val thestring :String? = keys["keys"]
        return thestring
        /*val temp = thestring?.substring(0,thestring.length-1)
        val valuesinOrder = temp?.split(",")?.toTypedArray()
        return valuesinOrder*/
    }

    fun translate (s:String):String
    {
        var m:MutableMap<String,String> = mutableMapOf("١" to "1" , "٢" to "2" ,"٣" to "3" , "٤" to "4" ,"٥" to "5" , "٦" to "6"
                ,"٧" to "7" , "٨" to "8" , "٩" to "9" , "٠" to "0")
        var res:String = ""
        for(c in s)
        {
            var temp:String = c.toString()
            if(m.containsKey(temp)) {
                res += m[temp]
            }
            else res+=temp
        }
        return res
    }
}
