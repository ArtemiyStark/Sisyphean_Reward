package com.artemiystark.sisyphean_reward.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

//Data Access Object for Score
@Dao
interface ScoreDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(score: Score)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(score: Score)

    @Delete
    suspend fun delete(score: Score)

    @Query("SELECT * FROM score")
    fun getAllScore(): Flow<List<Score>>

    @Query("SELECT * FROM score WHERE id =:scoreId")
    fun getScore(scoreId: Int): Flow<Score>
}

//Data Access Object for Settings
@Dao
interface SettingsDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(settings: Settings)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(settings: Settings)

    @Delete
    suspend fun delete(settings: Settings)

    @Query("SELECT * FROM settings")
    fun getAllSettings(): Flow<List<Settings>>

    @Query("SELECT * FROM settings WHERE id =:settingsId")
    fun getSettings(settingsId: Int): Flow<Settings>
}

//Data Access Object for Task
@Dao
interface TaskDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<Task>>

    @Query("SELECT * FROM tasks WHERE id =:taskId")
    fun getTask(taskId: Int): Flow<Task>
}


//Data Access Object for Schedule
@Dao
interface ScheduleDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(schedule: Schedule)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(schedule: Schedule)

    @Delete
    suspend fun delete(schedule: Schedule)

    @Query("SELECT * FROM schedules")
    fun getAllSchedules(): Flow<List<Schedule>>

    @Query("SELECT * FROM schedules WHERE task_id =:taskId")
    fun getAllSchedulesForTask(taskId:Int): Flow<List<Schedule>>

    @Query("SELECT * FROM schedules WHERE id =:scheduleId")
    fun getSchedule(scheduleId: Int): Flow<Schedule>
}

