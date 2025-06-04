package com.artemiystark.sisyphean_reward.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime


// Нагородні бали
@Entity(tableName = "score")
data class Score(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
//    val name:String,
    val totalScore: Int = 0
)

//Змінні з Налаштувань
@Entity(tableName = "settings")
data class Settings(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val darkTheme: Boolean = false, //false Light Theme, true Dark Theme
    val langUkr: Boolean = false, //false English, true Ukrainian
    val pixelFont: Boolean = false //false Ubuntu, true Minecraft Font

)

//Дані вписані в завдання
@Entity(tableName = "task")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val active: Boolean = true,
    val name: String,
    val description: String,
    val steps: Int = 1,
    val currentStep: Int = 0,
    val points: Int = 1,
    val lastRunTime: LocalDateTime,
    val nextRunTime: LocalDateTime
)

//Росклад виконання
data class Schedule(
    //@PrimaryKey(autoGenerate = true)
    val id: Int,
    // A field may contain an asterisk (-1), which always stands for
    // "first-last"
    val minute: Int,    //0-59
    val hour: Int,      //0-23
    val dayOfMonth: Int,//1-31
    val month: Int,     //1-12
    val dayOfWeek: Int, //1-7
    val task_id: Int
)