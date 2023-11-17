package com.example.myapplication.viewModelLiveData_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R

class ViewModelActivity : AppCompatActivity() {
    private lateinit var tvCount:TextView
    private lateinit var btnCount:Button
    private lateinit var viewModel: ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view_model)

        ///TODO: Initialize ViewModel
        viewModel= ViewModelProvider(this)[ActivityViewModel::class.java]

        tvCount=findViewById(R.id.tvCount)
        btnCount=findViewById(R.id.btnCount)
//        tvCount.text=viewModel.count.toString()

        viewModel.countLiveData.observe(this, Observer {
            tvCount.text=it.toString()
        })

        btnCount.setOnClickListener {
            viewModel.updateCount()
//            tvCount.text=viewModel.count.toString()
        }

    }
}