package com.example.myapplication.androidService_stopWatch_demo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import java.sql.Time
import java.util.Timer

class StopWatchService:Service() {

    private val timer= Timer()
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }

    companion object{
        const val CURRENT_TIME="current time"
        const val UPDATED_TIME="updated time"
    }
}