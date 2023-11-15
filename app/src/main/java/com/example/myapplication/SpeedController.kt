package com.example.myapplication

interface SpeedController {
    fun accelerate()
    fun decelerate()

    fun getBrandID():String{
        return "IHAN2343"
    }
}