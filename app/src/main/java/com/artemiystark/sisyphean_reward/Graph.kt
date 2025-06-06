package com.artemiystark.sisyphean_reward

import android.content.Context
import com.artemiystark.sisyphean_reward.data.Repository
import com.artemiystark.sisyphean_reward.data.SRDatabase

object Graph {
    lateinit var db: SRDatabase
        private set

    val repository by lazy {
        Repository(
            scoreDao = db.scoreDao(),
            settingsDao = db.settingsDao(),
            taskDao = db.taskDao(),
            scheduleDao = db.scheduleDao()
        )
    }

    fun provide(context: Context){
        db = SRDatabase.getDatabase(context)
    }

}