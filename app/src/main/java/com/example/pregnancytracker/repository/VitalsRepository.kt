package com.example.pregnancytracker.repository

import com.example.pregnancytracker.data.local.dao.VitalsDao
import com.example.pregnancytracker.data.local.entity.VitalsEntity

class VitalsRepository(private val dao: VitalsDao) {

    val vitalsList = dao.getAllVitals()

    suspend fun insert(vitals: VitalsEntity) {
        dao.insertVitals(vitals)
    }
}
