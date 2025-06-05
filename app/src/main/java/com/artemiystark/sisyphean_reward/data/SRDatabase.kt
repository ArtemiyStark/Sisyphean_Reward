package com.artemiystark.sisyphean_reward.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@TypeConverters(value = [DateConverter::class])
@Database(
    entities = [Score::class, Settings::class, Task::class, Schedule::class],
    version = 1,
    exportSchema = false
)
abstract class SRDatabase: RoomDatabase() {
    abstract fun scoreDao(): ScoreDao
    abstract fun settingsDao(): SettingsDao
    abstract fun taskDao(): TaskDao
    abstract fun scheduleDao(): ScheduleDao

    companion object{
        @Volatile
        var INSTANCE: SRDatabase? = null
        fun getDatabase(context: Context): SRDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    SRDatabase::class.java,
                    "sr_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}