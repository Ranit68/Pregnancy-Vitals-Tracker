package com.example.pregnancytracker.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pregnancytracker.data.local.database.AppDatabase
import com.example.pregnancytracker.data.local.entity.VitalsEntity
import com.example.pregnancytracker.repository.VitalsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class VitalsViewModel(application: Application) :
    AndroidViewModel(application) {

    private val dao =
        AppDatabase.getDatabase(application).vitalsDao()

    private val repository = VitalsRepository(dao)
    val vitals: StateFlow<List<VitalsEntity>> =
        repository.vitalsList.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )
    fun addVitals(vitalsEntity: VitalsEntity) {
        viewModelScope.launch {
            repository.insert(vitalsEntity)
        }
    }
}
