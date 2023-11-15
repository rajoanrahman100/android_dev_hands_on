package com.example.myapplication.model

import android.util.Log

//By default every class is Final. To make the class available to extend from another class we use 'open'
open class Car {

    open var maxSpeed=30
    open fun start(){
        Log.i("OOP TAG","Car is Starting....")
        Log.i("OOP TAG","Maximum speed is $maxSpeed")
    }
}