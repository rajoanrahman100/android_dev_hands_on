package com.example.myapplication.androidService_stopWatch_demo

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityStopWatchMainBinding
import kotlin.math.roundToInt

class StopWatchMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStopWatchMainBinding
    private var isStarted = false
    private lateinit var serviceIntent: Intent
    private var time = 0.0

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStopWatchMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        serviceIntent = Intent(applicationContext, StopWatchService::class.java)
        registerReceiver(updateTime, IntentFilter(StopWatchService.UPDATED_TIME))

        binding.btnStopWatchStart.setOnClickListener {
            startOrStop()
        }


        binding.btnStopWatchReset.setOnClickListener {
            reset()
        }


    }

    private fun startOrStop() {
        if (isStarted) {
            stop()
        } else start()
    }

    private fun start() {
        serviceIntent.putExtra(StopWatchService.CURRENT_TIME, time)
        startService(serviceIntent)
        binding.btnStopWatchStart.text = "Stop"
        isStarted = true
    }

    private fun stop() {
        stopService(serviceIntent)
        binding.btnStopWatchStart.text = "Resume"
        isStarted = false
    }

    private fun reset() {
        stop()
        time = 0.0
        binding.stopWatchTV.text = getFormattedTime(time)
        binding.btnStopWatchStart.text = "Start"
    }

    ///TODO: Declare broadcast receiver
    private val updateTime: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            time = intent.getDoubleExtra(StopWatchService.CURRENT_TIME, 0.0)
            binding.stopWatchTV.text = getFormattedTime(time)

        }

    }

    private fun getFormattedTime(time: Double): String {
        var timeInt = time.roundToInt();
        var hours = timeInt % 86400 / 3600
        var minutes = timeInt % 86400 % 3600 / 60
        var seconds = timeInt % 86400 % 3600 % 60

        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }


}