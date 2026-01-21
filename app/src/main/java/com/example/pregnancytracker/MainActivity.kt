package com.example.pregnancytracker

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.pregnancytracker.ui.screens.HomeScreen
import com.example.pregnancytracker.ui.theme.PregnancyTrackerTheme
import com.example.pregnancytracker.viewModel.VitalsViewModel
import com.example.pregnancytracker.worker.ReminderWorker
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {

    private val requestNotificationPermission =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createNotificationChannel()
        askNotificationPermission()
        scheduleVitalsReminder()
        setContent {
            PregnancyTrackerTheme {
                val viewModel: VitalsViewModel = viewModel()
                HomeScreen(viewModel)
            }
        }
    }
    private fun askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestNotificationPermission.launch(
                Manifest.permission.POST_NOTIFICATIONS
            )
        }
    }
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(
                "vitals_channel",
                "Vitals Reminder",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Reminds mother to log pregnancy vitals"
            }

            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }
    private fun scheduleVitalsReminder() {

        val workRequest =
            PeriodicWorkRequestBuilder<ReminderWorker>(
                5,
                TimeUnit.HOURS
            ).build()

        WorkManager.getInstance(this)
            .enqueueUniquePeriodicWork(
                "vitals_reminder_work",
                ExistingPeriodicWorkPolicy.UPDATE,
                workRequest
            )
    }
}
