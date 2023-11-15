package com.example.myapplication.model

import android.util.Log

class Driver(var name:String, salary:Int) { //'name' is a property and 'salary' is parameter of the constructor

    private var totalSalary=0;
    private val car=Car()

    //Everytime the Driver object will create. This init block will be executed
    init {
        totalSalary+=salary
        car.maxSpeed=150
        car.start()

        //One way to assign name on driverName variable
        //diverName=name
    }

    fun showDetails(){
        Log.i("OOP TAG","Name of my driver is $name")
        Log.i("OOP TAG","His salary is $totalSalary BDT")
    }
}