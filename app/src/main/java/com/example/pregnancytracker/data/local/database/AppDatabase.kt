package com.example.pregnancytracker.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pregnancytracker.data.local.dao.VitalsDao
import com.example.pregnancytracker.data.local.entity.VitalsEntity;

@Database(
    entities = [VitalsEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun vitalsDao(): VitalsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "vitals_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
