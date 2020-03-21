package com.bradley.wilson.jokes.core.network.di

import com.bradley.wilson.jokes.core.network.NetworkHandler
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule: Module = module {
    single {
        val baseUrl = "https://icanhazdadjoke.com"
        val httpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor {
                val newRequest = it.request().newBuilder()
                    .addHeader("Accept", "application/json")
                    .build()
                return@addInterceptor it.proceed(newRequest)
            }.build()

        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        NetworkHandler(androidContext())
    }
}