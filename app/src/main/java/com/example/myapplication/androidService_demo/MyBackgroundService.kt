package com.example.myapplication.androidService_demo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyBackgroundService:Service() {

    init {
        Log.i(TAG,"Service has been created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG,"Service has been started")
        val name=intent?.getStringExtra(NAME)
        val marks=intent?.getIntExtra(MARKS,0)
        Log.i(TAG,"Name is $name ans Marks is $marks")
        return START_STICKY
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onDestroy() {
        Log.i(TAG,"Service has been destroyed")
        super.onDestroy()
    }

    companion object{
        const val TAG="MYTAG"
        const val NAME="Name"
        const val MARKS="Marks"
    }
}