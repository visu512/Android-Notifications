package com.example.androidnotifications

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidnotifications.databinding.ActivityDataPassBinding

class DataPassActivity : AppCompatActivity() {
    private val binding: ActivityDataPassBinding by lazy{
        ActivityDataPassBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

      binding.textView.setText(intent.getStringExtra("DATA_REC"))

    }
}