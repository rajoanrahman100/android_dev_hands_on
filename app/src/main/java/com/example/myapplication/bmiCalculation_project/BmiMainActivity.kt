package com.example.myapplication.bmiCalculation_project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myapplication.R

class BmiMainActivity : AppCompatActivity() {
    private lateinit var etWeight: EditText
    private lateinit var etHeight: EditText
    private lateinit var calculateButton: Button
    private lateinit var tvIndex: TextView
    private lateinit var tvInfo: TextView
    private lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_main)

        etWeight = findViewById(R.id.etWeight)
        etHeight = findViewById(R.id.etHeight)
        calculateButton = findViewById(R.id.btnCalculate)
        tvIndex = findViewById(R.id.tvIndex)
        tvInfo = findViewById(R.id.tvInfo)
        tvResult = findViewById(R.id.tvResult)

        calculateButton.setOnClickListener {
            var weightValue = etWeight.text
            var heightValue = etHeight.text

            if (validateInput(weightValue.toString(), heightValue.toString())) {
                var result = weightValue.toString().toFloat() / heightValue.toString().toFloat()

                var bmiValue = (weightValue.toString().toFloat()) / ((heightValue.toString()
                    .toFloat() / 100) * (heightValue.toString().toFloat() / 100))
                var bmi2Digits = String.format("%.2f", bmiValue).toFloat()
                displayBmiResult(bmi2Digits)
            }


        }


    }

    private fun displayBmiResult(bmi: Float) {
        tvIndex.text = bmi.toString()

        var color = 0;

        if (bmi < 18.5) {
            tvResult.text = "Underweight"
            color = R.color.under_weight

        } else if (bmi in 18.5..24.9) {
            tvResult.text = "Normal Weight"
            color = R.color.normal
        } else if (bmi in 25.0..29.9) {
            tvResult.text = "Over Weight"
            color = R.color.over_weight
        } else {
            tvResult.text = "Obesity"
            color = R.color.obese
        }

        //Change the text color according to result
        tvResult.setTextColor(ContextCompat.getColor(this, color))


    }

    private fun validateInput(weight: String, height: String): Boolean {

        return when {
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Weight is empty", Toast.LENGTH_SHORT).show()
                return false
            }

            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty", Toast.LENGTH_SHORT).show()
                return false
            }

            else -> {
                return true
            }
        }

    }
}