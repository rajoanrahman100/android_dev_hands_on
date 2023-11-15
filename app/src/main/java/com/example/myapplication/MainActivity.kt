package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.model.Car
import com.example.myapplication.model.Driver
import com.example.myapplication.model.MyCar

class MainActivity : AppCompatActivity() {

    private var enteredMessage:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MY TAG","MainActivity: OnCreate")

        //declare car object
//        val car=Car()
//        car.maxSpeed=150 //Change the max speed value
//        car.start()

        //declare driver object
        //val driver=Driver(name = "Imtiaz", salary = 10000)
       // driver.showDetails()

        //Calling the MyCar() class who extended the Car() class and have the values
        val myCar=MyCar()
        myCar.start()


        val helloTextVIew=findViewById<TextView>(R.id.tvHello)
        val editText=findViewById<EditText>(R.id.tvName_editText)
        val submitButton=findViewById<Button>(R.id.button)
        val offerButton=findViewById<Button>(R.id.btnOffer)

        submitButton.setOnClickListener {
            if(editText.text.isEmpty()){
                Toast.makeText(this@MainActivity,"Please, enter your name",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            enteredMessage=editText.text.toString()

            Log.i("MY MESSAGE","Message: $enteredMessage")

            val message="Welcome $enteredMessage"
            offerButton.visibility=VISIBLE

            helloTextVIew.text=message
            editText.text.clear()
        }

        offerButton.setOnClickListener {
            val intent=Intent(this,SecondActivity::class.java)
            //Pass data to second activity
            intent.putExtra("USERNAME",enteredMessage)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i("My Tag","MainActivity: On Start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("My Tag","MainActivity: On Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("My Tag","MainActivity: On Pause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("My Tag","MainActivity: On Restart")
    }

    override fun onStop() {
        super.onStop()
        Log.i("My Tag","MainActivity: On Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("My Tag","MainActivity: On Destroy")
    }


}