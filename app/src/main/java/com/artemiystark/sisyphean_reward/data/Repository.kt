package com.artemiystark.sisyphean_reward.data

class Repository(
    private val scoreDao: ScoreDao,
    private val settingsDao: SettingsDao,
    private val taskDao: TaskDao,
    private val scheduleDao: ScheduleDao
) {

    // for Task
    val tasks = taskDao.getAllTasks()

    suspend fun insertTask(task: Task){
        taskDao.insert(task)
    }
    suspend fun updateTask(task: Task){
        taskDao.update(task)
    }
    suspend fun deleteTask(task: Task){
        taskDao.delete(task)
    }

    // for Schedule
    suspend fun insertSchedule(schedule: Schedule){
        scheduleDao.insert(schedule)
    }
    suspend fun updateSchedule(schedule: Schedule){
        scheduleDao.update(schedule)
    }
    suspend fun deleteSchedule(schedule: Schedule){
        scheduleDao.delete(schedule)
    }
    fun getAllSchedulesForTask(taskId:Int) =
        scheduleDao.getAllSchedulesForTask(taskId)

    // for Score
    val score = scoreDao.getScore(0)

    // for Settings
    val settings = settingsDao.getSettings(0)

}