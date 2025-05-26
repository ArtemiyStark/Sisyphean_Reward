package com.artemiystark.sisyphean_reward.data

import java.time.LocalDateTime

// Нагородні бали
data class Score(
    val id:Int = 0,
//    val name:String,
    val totalScore: Int = 0
)

//Змінні з Налаштувань
data class Settings(
    val id:Int = 0,

)

//Дані вписані в завдання
data class Task(
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

