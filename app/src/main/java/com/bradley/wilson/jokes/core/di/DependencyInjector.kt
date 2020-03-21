package com.bradley.wilson.jokes.core.di

import android.content.Context
import com.bradley.wilson.jokes.core.network.di.networkModule
import com.bradley.wilson.jokes.dadjokes.di.dadJokesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

object DependencyInjector {

    private val coreModules = listOf(
        networkModule
    )

    private val highLevelModules = listOf(
        dadJokesModule
    )

    fun initialise(context: Context) {
        startKoin {
            androidContext(context)
            modules(

            )
        }
    }
}
