package com.example.myapplication.shared_pref

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R

class SharedPrefActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var nextButton: Button
    private lateinit var sf: SharedPreferences
    private lateinit var sfEditor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        //Initialize shared pref
        nameEditText=findViewById(R.id.etName)
        ageEditText=findViewById(R.id.etAge)
        nextButton=findViewById(R.id.nextButton)
        sf=getSharedPreferences("my_sf", MODE_PRIVATE)
        sfEditor=sf.edit()
    }

    override fun onPause() {
        super.onPause()
        val name=nameEditText.text.toString()
        val age=ageEditText.text.toString().toInt()

        Log.i("On Pause Name",name)
        Log.i("On Pause Age",age.toString())

        sfEditor.apply {
            putString("sf_name",name)
            putInt("sf_age",age)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        val name=sf.getString("sf_name",null)
        val age=sf.getInt("sf_age",0)

        Log.i("Resume Name",name.toString())
        Log.i("Resume Age",age.toString())

        nameEditText.setText(name)

        if (age!=0){
            ageEditText.setText(age.toString())
        }


    }
}