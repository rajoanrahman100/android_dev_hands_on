package com.example.myapplication.model

import android.util.Log
import com.example.myapplication.SpeedController

class MyCar: Car(),SpeedController { //Now MyCar can access all the non private variable from Car() class


    //Override variable and function
    override var maxSpeed: Int=100

    override fun start() {
        super.start()
        Log.i("OOP TAG","My Car is Starting from Car Class....Brand is ${getBrandID()}")
        Log.i("OOP TAG","My Car max speed is $maxSpeed")
    }

    override fun accelerate() {
        TODO("Not yet implemented")

    }

    override fun decelerate() {
        TODO("Not yet implemented")
    }
}