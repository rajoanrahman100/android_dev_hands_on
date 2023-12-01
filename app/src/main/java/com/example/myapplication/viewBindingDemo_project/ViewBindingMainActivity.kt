package com.example.myapplication.viewBindingDemo_project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityViewBindingMainBinding

class ViewBindingMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewBindingMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_view_binding_main)

        binding = ActivityViewBindingMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val messageView = findViewById<TextView>(R.id.tvMessageView)
        val submitButton = findViewById<Button>(R.id.btnInputSubmit)
        val inputText = findViewById<EditText>(R.id.etInputText)

        ///TODO: Without ViewBinding
        /*submitButton.setOnClickListener {
            messageView.text = inputText.text
            inputText.setText("")
        }*/

        ///TODO: With ViewBinding
        /*binding.btnInputSubmit.setOnClickListener {
            binding.tvMessageView.text = binding.etInputText.text
            binding.etInputText.setText("")
        }*/

        ///TODO: With binding.apply method
        binding.apply {
            btnInputSubmit.setOnClickListener {
                tvMessageView.text = etInputText.text
                etInputText.setText("")
            }
        }
    }
}