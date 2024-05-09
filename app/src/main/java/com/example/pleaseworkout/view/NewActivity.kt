package com.example.pleaseworkout.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.pleaseworkout.R
import com.example.pleaseworkout.databinding.ActivityMainBinding

class NewActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var workoutName: TextView
    private lateinit var workoutExplain: TextView
    private lateinit var workoutType: TextView
    private lateinit var workoutImage: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_new)

        workoutName = findViewById(R.id.workoutName)
        workoutExplain = findViewById(R.id.workoutExplain)
        workoutType = findViewById(R.id.workoutType)
        workoutImage = findViewById(R.id.workoutImage)

        val recieveName = intent.getStringExtra("workoutName")
        val recieveType = intent.getStringExtra("workoutType")
        val recieveDesc = intent.getStringExtra("workoutExplain")
        val recieveImageJuice = intent.getStringExtra("workoutImage")

        Glide.with(this)
            .load(recieveImageJuice)
            .into(workoutImage)

        workoutName.text = recieveName
        workoutType.text = recieveType
        workoutExplain.text = recieveDesc





    }


}