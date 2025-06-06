package com.artemiystark.sisyphean_reward

import android.app.Application

class SRApplication: Application() {
        override fun onCreate() {
            super.onCreate()
            Graph.provide(this)
        }
}