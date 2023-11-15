package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var nameTextView:TextView
    private var intentText:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        nameTextView=findViewById(R.id.nameTxtView)
        intentText= intent.getStringExtra("USERNAME").toString()

        nameTextView.text=intentText

    }
}