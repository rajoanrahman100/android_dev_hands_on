package com.example.myapplication.viewModelScopeDemo_project

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R

class ViewModelScopeActivity : AppCompatActivity() {
    private lateinit var scopeActivityViewModel: ScopeActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model_scope)
        scopeActivityViewModel = ViewModelProvider(this)[ScopeActivityViewModel::class.java]
        scopeActivityViewModel.getUserData()
        scopeActivityViewModel.users.observe(this, Observer { userList ->
            userList.forEach {
                Log.i("MyTag", "Name ${it.name} and Id ${it.id}")
            }
        })
    }
}