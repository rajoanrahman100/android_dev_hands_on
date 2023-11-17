package com.example.myapplication.coroutines_project

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutinesMainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var messageTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_main)

        messageTextView = findViewById(R.id.tvMessage)
        val textView = findViewById<TextView>(R.id.tvCount)
        val countButton = findViewById<Button>(R.id.btnCount)
        val downloadButton = findViewById<Button>(R.id.btnDownload)

        countButton.setOnClickListener {
            textView.text = count++.toString()
        }
        downloadButton.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
            //downloadUserData()
        }
    }

    private suspend fun downloadUserData() {
        for (i in 1..5000000) {
            Log.i("My Tag", "Download User $i in ${Thread.currentThread().name}")

            //Switch to main thread to show the messageTextView
            withContext(Dispatchers.Main) {
                messageTextView.text = "Download User $i"
            }
            delay(100)
        }
    }
}