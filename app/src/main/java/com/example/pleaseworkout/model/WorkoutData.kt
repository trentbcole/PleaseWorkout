package com.example.pleaseworkout.model

class WorkoutData {
    var workoutName: String? = null
    var workoutImage: String? = null
    var workoutDifficulty: String? = null
    var workoutExplain: String? = null
    constructor(

    )

    constructor(
        workoutName: String?,
        workoutImage: String?,
        workoutDifficulty: String?,
        workoutExplain: String?
    ) {
        this.workoutName = workoutName
        this.workoutImage = workoutImage
        this.workoutDifficulty = workoutDifficulty
        this.workoutExplain = workoutExplain
    }

}