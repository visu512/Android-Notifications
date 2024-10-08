package com.example.androidnotifications

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

// create notification channel

class NotificationChannelCreate :Application(){
    final val CHANNEL_ID1 = "CHANNEL_ID1"
    final val CHANNEL_ID2 = "CHANNEL_ID2"
    final private val CHANNEL_ID3 = "CHANNEL_ID3"
    final private val CHANNEL_ID4 = "CHANNEL_ID4"



    override fun onCreate() {
        super.onCreate()
        // create channel
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){  // oreo(O) notification channel work Above on oreo 26 APi to above
            // 1 channel create
            val channel1 = NotificationChannel(CHANNEL_ID1,"Channel 1",NotificationManager.IMPORTANCE_HIGH)
            channel1.description = "This is High Important level Channel"

            // 2 channel create
            val channel2 = NotificationChannel(CHANNEL_ID2,"Channel 2",NotificationManager.IMPORTANCE_DEFAULT)
            channel2.description = "This is High Important level Channel"

            // 2 channel create
            val channel3 = NotificationChannel(CHANNEL_ID3,"Channel 3",NotificationManager.IMPORTANCE_DEFAULT)
            channel3.description = "This is High Important level Channel"

            // 2 channel create
            val channel4 = NotificationChannel(CHANNEL_ID4,"Channel 4",NotificationManager.IMPORTANCE_DEFAULT)
            channel4.description = "This is High Important level Channel"

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            manager.createNotificationChannel(channel1)
            manager.createNotificationChannel(channel2)
            manager.createNotificationChannel(channel3)
            manager.createNotificationChannel(channel4)


            //// go ot notification of app and view created 4 channel
        }
    }

}