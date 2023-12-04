package com.example.myapplication.androidService_stopWatch_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityStopWatchMainBinding

class StopWatchMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStopWatchMainBinding
    private var isStarted=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStopWatchMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            btnStopWatchStart.setOnClickListener {
                startOrStop()
            }


            btnStopWatchReset.setOnClickListener {
                reset()
            }
        }

    }

    private fun startOrStop(){
        if(isStarted){
            stop()
        }
        else
            start()
    }

    private fun start() {
        binding.btnStopWatchStart.text = "Stop"
        isStarted=true
    }
    private fun stop() {
        binding.btnStopWatchStart.text="Start"
        isStarted=false
    }
    private fun reset() {}
}