package com.example.pregnancytracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vitals")
data class VitalsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val sysBP: String,
    val diaBP: String,
    val heartRate: String,
    val weight: String,
    val babyKicks: String,
    val timestamp: Long = System.currentTimeMillis()
)
