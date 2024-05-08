package com.example.pleaseworkout.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pleaseworkout.databinding.ActivityMainBinding
import com.example.pleaseworkout.model.WorkoutData
import com.example.pleaseworkout.viewmodel.WorkoutAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ChestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mDataBase: DatabaseReference
    private lateinit var chestList: ArrayList<WorkoutData>
    private lateinit var mAdapter: WorkoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        chestList = ArrayList()
        mAdapter = WorkoutAdapter(this, chestList)
        binding.recyclerChest.layoutManager = LinearLayoutManager(this)
        binding.recyclerChest.setHasFixedSize(true)

        getWorkoutData()
    }

    private fun getWorkoutData() {
        mDataBase = FirebaseDatabase.getInstance().getReference("ChestWorkouts")
        mDataBase.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    chestList.clear()
                    for(chestSnapshot in snapshot.children) {
                        val chest = chestSnapshot.getValue(WorkoutData::class.java)
                        chestList.add(chest!!)
                    }
                    binding.recyclerChest.adapter = mAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ChestActivity, error.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}