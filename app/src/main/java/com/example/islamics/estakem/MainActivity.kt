package com.example.islamics.estakem

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v7.widget.CardView


import android.widget.RelativeLayout

import android.view.View
import android.widget.GridLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()
{

    var context:Context = this


    override fun onCreate(savedInstanceState: Bundle?)
    {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        val grid = mainGrid as GridLayout
        val childCount = grid.getChildCount()

        for (i in 0 until childCount) {
            val container = grid.getChildAt(i) as CardView
            container.setOnClickListener {
                if(i == 0) {
                    val intent = Intent(context, mychallenges::class.java)
                    startActivity(intent)
                } else if(i == 1) {
                    val intent = Intent(context, ershadat::class.java)
                    startActivity(intent)
                } else if(i == 2) {
                    val intent = Intent(context , farayed::class.java)
                    intent.putExtra("name","farayed")
                    startActivity(intent)
                } else if(i == 3) {
                    val intent = Intent(context, engazat::class.java)
                    startActivity(intent)
                } else if(i == 4) {
                    val intent = Intent(context , farayed::class.java)
                    intent.putExtra("name","sonan_mahgora")
                    startActivity(intent)
                } else if(i == 5) {
                    val intent = Intent(context , farayed::class.java)
                    intent.putExtra("name","nwafel")
                    startActivity(intent)
                } else if(i == 6) {
                    val intent = Intent(context ,tarkzanb::class.java)
                    intent.putExtra("mystate","mine")
                    startActivity(intent)
                } else if(i== 7) {
                    val intent = Intent(this ,tarkzanb::class.java)
                    intent.putExtra("mystate","mine")
                    startActivity(intent)
                } else if(i == 8){
                    val intent = Intent(context ,tarkzanb::class.java)
                    intent.putExtra("mystate","znb")
                   startActivity(intent)
                }
            }
        }



    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    //---------------------------------


    /************************/
    fun omar(notificationId: Int)
    {

        var notification_manager: NotificationManager =  this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager;

        var chanel_id:String = "3000"
        var name:CharSequence = "Channel Name"
        var description:String = "Chanel Description"
        var importance:Int = NotificationManager.IMPORTANCE_LOW
        var notification_builder = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            var mChannel: NotificationChannel = NotificationChannel(chanel_id, name, importance)
            mChannel.setDescription(description)
            mChannel.enableLights(true)
            mChannel.setLightColor(Color.BLUE)
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
            nm.notify(51 ,notification_builder.build())



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
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP , java.lang.System.currentTimeMillis(),1000*60*60*24,pendingIntent)

        }
        else
        {
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
            nm.notify(50 ,notification_builder.build())



            val notification = notification_builder.build()

            val notificationIntent = Intent(this, MyNotificationPublisher::class.java)
            notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION_ID, notificationId)
            notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION, notification)
            val pendingIntent = PendingIntent.getBroadcast(this, notificationId, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT)

            // val futureInMillis = SystemClock.elapsedRealtime() + delay
            val alarmManager = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP , java.lang.System.currentTimeMillis(), 1000*60*60*24, pendingIntent)
        }






    }

    /********************/


}

