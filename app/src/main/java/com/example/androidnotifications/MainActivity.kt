package com.example.androidnotifications

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.androidnotifications.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // High-level notification (inside the app)
        binding.High.setOnClickListener {
            // Create RemoteViews object for custom notification
            val customLayout = RemoteViews(packageName, R.layout.custom_notification)

            // Set custom title and content text from user input
            customLayout.setTextViewText(R.id.title, binding.title.text.toString())
            customLayout.setTextViewText(R.id.text, binding.content.text.toString())

            // Create an intent to pass data to another activity
            val intent = Intent(this, DataPassActivity::class.java).apply {
                putExtra("DATA_REC", binding.content.text.toString()) // Pass the content as extra data
            }

            // Create the PendingIntent
            val pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            // Build the notification
            val notification = NotificationCompat.Builder(this, NotificationChannelCreate().CHANNEL_ID1)
                .setSmallIcon(R.drawable.music_note) // Small icon (this is mandatory)
                .setStyle(NotificationCompat.DecoratedCustomViewStyle()) // Custom layout styling
                .setCustomContentView(customLayout) // Set custom layout
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColorized(true)
                .setAutoCancel(true) // Dismiss notification on click
                .setContentIntent(pendingIntent) // Set the intent for notification click
                .build()

            // Show the notification
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(1, notification)
        }

        // Low-level notification (outside the app)
        binding.Low.setOnClickListener {
            val notification = NotificationCompat.Builder(this, NotificationChannelCreate().CHANNEL_ID2)
                .setSmallIcon(R.drawable.heart)
                .setContentTitle(binding.title.text.toString())
                .setContentText(binding.content.text.toString())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            // Show the notification
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(2, notification)
        }
    }
}
