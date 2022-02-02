package com.ebookfrenzy.notifydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Notification
import android.app.PendingIntent
import android.view.View
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Icon


class MainActivity : AppCompatActivity() {

    private var notificationManager: NotificationManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager =
        getSystemService(
        NOTIFICATION_SERVICE
        ) as NotificationManager

        createNotificationChannel(
        "com.ebookfrenzy.notifydemo.news",
        "NotifyDemo News",
        "Example News Channel")
    }

    fun sendNotification(view: View) {
        val icon: Icon = Icon.createWithResource(this,
          android.R.drawable.ic_dialog_info)
        val action: Notification.Action =
            Notification.Action.Builder(icon, "Open", pendingIntent).build()
        val channelID = "com.ebookfrenzy.notifydemo.news"
        val resultIntent = Intent(this, ResultActivity::class.java)
        val notification = Notification.Builder(this@MainActivity, channelID)

            .setContentTitle("Example Notification")
            .setContentText("This is an example notification.")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setChannelId(channelID)
            .setContentIntent(pendingIntent)
            .setActions(action)
            .setNumber(10)
            .build()
        notificationManager?.notify(notificationID, notification)
    }
}