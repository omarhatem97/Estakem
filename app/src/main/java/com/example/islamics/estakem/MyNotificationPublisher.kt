package com.example.islamics.estakem

import android.app.Notification
import android.content.Context.NOTIFICATION_SERVICE
import android.app.NotificationManager
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context


class MyNotificationPublisher : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = intent.getParcelableExtra<Notification>(NOTIFICATION)
        val notificationId = intent.getIntExtra(NOTIFICATION_ID, 0)
        notificationManager.notify(notificationId, notification)
    }

    companion object {

        var NOTIFICATION_ID = "notification_id"
        var NOTIFICATION = "notification"
    }
}
