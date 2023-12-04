package com.example.myapplication.androidService_demo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.androidService_demo.MyBackgroundService.Companion.MARKS
import com.example.myapplication.androidService_demo.MyBackgroundService.Companion.NAME
import com.example.myapplication.androidService_demo.MyBackgroundService.Companion.TAG
import com.example.myapplication.databinding.ActivityServiceMainBinding

class ServiceMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityServiceMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_main)

        binding = ActivityServiceMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val serviceIntent = Intent(this, MyBackgroundService::class.java)

        ///TODO:Sending value to service
        serviceIntent.putExtra(MyBackgroundService.NAME,"Alex")
        serviceIntent.putExtra(MyBackgroundService.MARKS,80)

        binding.apply {
            btnServiceStart.setOnClickListener {
                Log.i(TAG, "Starting Service")
                startService(serviceIntent)
            }

            btnServiceStop.setOnClickListener {
                Log.i(TAG, "Stopping Service")
                stopService(serviceIntent)
            }
        }
    }
}