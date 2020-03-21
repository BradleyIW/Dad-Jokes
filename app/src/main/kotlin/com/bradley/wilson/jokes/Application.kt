package com.bradley.wilson.jokes

import android.app.Application
import com.bradley.wilson.jokes.core.di.DependencyInjector

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        DependencyInjector.initialise(this)
    }
}