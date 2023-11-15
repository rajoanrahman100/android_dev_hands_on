package com.example.myapplication.viewModelLiveData_project

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel:ViewModel() {

    var count=0
    var countLiveData=MutableLiveData<Int>() //we are going to increase the count value using live data

    init {
        countLiveData.value=0 //Initialize value set to 0
    }

    fun updateCount(){
//        count += 1
        countLiveData.value=(countLiveData.value)?.plus(1)
    }
}