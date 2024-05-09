package com.example.pleaseworkout.viewmodel

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pleaseworkout.R
import com.example.pleaseworkout.databinding.ChestListBinding
import com.example.pleaseworkout.model.WorkoutData

class WorkoutAdapter (

    var c: Context, var chestlist: ArrayList<WorkoutData>
): RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>() {

    inner class WorkoutViewHolder(var v: ChestListBinding): RecyclerView.ViewHolder(v.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<ChestListBinding>(
            inflater, R.layout.chest_list, parent, false)
        return WorkoutViewHolder(v)
    }

    override fun getItemCount(): Int {
        return chestlist.size
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        val newList = chestlist[position]
        holder.v.chestworkout = chestlist[position]
        holder.v.root.setOnClickListener {
            val workoutImage = newList.workoutImage
            val workoutName = newList.workoutName
            val workoutExplain = newList.workoutExplain
            val workoutDiff = newList.workoutDifficulty

        }
    }
}