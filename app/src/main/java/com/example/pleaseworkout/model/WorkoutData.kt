package com.example.pleaseworkout.model

class WorkoutData {
    var workoutName: String? = null
    var workoutImage: String? = null
    var workoutType: String? = null
    var workoutExplain: String? = null
    constructor(

    )

    constructor(
        workoutName: String?,
        workoutImage: String?,
        workoutType: String?,
        workoutExplain: String?
    ) {
        this.workoutName = workoutName
        this.workoutImage = workoutImage
        this.workoutType = workoutType
        this.workoutExplain = workoutExplain
    }

}