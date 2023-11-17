package com.example.myapplication.viewModelScopeDemo_project

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class ScopeActivityViewModel:ViewModel() {

    private val myJob= Job()
    private val myScope= CoroutineScope(Dispatchers.IO+myJob) //Initialize coroutine

    fun getUserData(){
        myScope.launch {

        }
    }

    override fun onCleared() {
        super.onCleared()
        myJob.cancel()
    }
}