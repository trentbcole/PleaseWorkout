package com.example.pleaseworkout.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pleaseworkout.databinding.ActivityMainBinding
import com.example.pleaseworkout.model.WorkoutData
import com.example.pleaseworkout.viewmodel.WorkoutAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class BackActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mDataBase: DatabaseReference
    private lateinit var backList: ArrayList<WorkoutData>
    private lateinit var mAdapter: WorkoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        backList = ArrayList()
        mAdapter = WorkoutAdapter(this, backList)
        binding.recyclerChest.layoutManager = LinearLayoutManager(this)
        binding.recyclerChest.setHasFixedSize(true)

        getWorkoutData()
    }

    private fun getWorkoutData() {
        mDataBase = FirebaseDatabase.getInstance().getReference("BackWorkouts")
        mDataBase.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    backList.clear()
                    for(chestSnapshot in snapshot.children) {
                        val chest = chestSnapshot.getValue(WorkoutData::class.java)
                        backList.add(chest!!)
                    }
                    binding.recyclerChest.adapter = mAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@BackActivity, error.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}