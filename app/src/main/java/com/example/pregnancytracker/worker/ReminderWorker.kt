package com.example.pregnancytracker.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.pregnancytracker.notification.NotificationHelper

class ReminderWorker(
    context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    override fun doWork(): Result {
        NotificationHelper.showNotification(
            applicationContext,
            "Time to log your vitals",
            "Please update your pregnancy vitals for better health tracking."
        )

        return Result.success()
    }
}
