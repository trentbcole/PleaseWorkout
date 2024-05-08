package com.example.pleaseworkout.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pleaseworkout.R


class Calculate: AppCompatActivity() {

    private lateinit var resultText: TextView
    private lateinit var weightUserText: EditText
    private lateinit var heightUserText: EditText
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calc_layout)

        resultText = findViewById(R.id.bmiResultText)
        weightUserText = findViewById(R.id.weightInputText)
        heightUserText = findViewById(R.id.heightInputText)
        calculateButton = findViewById(R.id.calculateButton)

        calculateButton.setOnClickListener {
            CalculateBMI()
        }



    }

    private fun CalculateBMI() {
        val weightLbs = weightUserText.text.toString().toDoubleOrNull()
        val heightInches = heightUserText.text.toString().toDoubleOrNull()

        if (weightLbs == null || heightInches == null) {
            resultText.text = "Invalid input"
            return
        }

        val bmi = calculateBMIValue(weightLbs, heightInches)
        val formattedBMI = String.format("%.1f", bmi)
        resultText.text = "BMI: $formattedBMI"
    }

    private fun calculateBMIValue(weightLbs: Double, heightInches: Double): Double {
        val weightKg = weightLbs * 0.453592 // Convert lbs to kg
        val heightMeters = heightInches * 0.0254 // Convert inches to meters

        return weightKg / (heightMeters * heightMeters)
    }
}


