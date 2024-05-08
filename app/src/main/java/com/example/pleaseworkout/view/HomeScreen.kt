package com.example.pleaseworkout.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.pleaseworkout.R
import com.example.pleaseworkout.databinding.ActivityMainBinding

class HomeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var chestBtn: Button
    private lateinit var calcBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home_screen)

        chestBtn = findViewById(R.id.chestButton)
        calcBtn = findViewById(R.id.bmiButton)

        chestBtn.setOnClickListener {
            val intent = Intent(this, ChestActivity::class.java)
            startActivity(intent)
        }

        calcBtn.setOnClickListener {
            val intent = Intent(this, Calculate::class.java)
            startActivity(intent)
        }







    }
}