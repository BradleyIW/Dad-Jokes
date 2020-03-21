package com.bradley.wilson.jokes.core.network.di

import com.bradley.wilson.jokes.core.network.ApiService
import com.bradley.wilson.jokes.core.network.di.NetworkDependencyBuilder.BASE_URL
import com.bradley.wilson.jokes.core.network.di.NetworkDependencyBuilder.httpClient
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkDependencyBuilder {
    const val BASE_URL = "https://icanhazdadjoke.com"
    val httpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor {
            val newRequest = it.request().newBuilder()
                .addHeader("Accept", "application/json")
                .build()
            return@addInterceptor it.proceed(newRequest)
        }.build()
}

val networkModule: Module = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    factory {
        ApiService()
    }
}