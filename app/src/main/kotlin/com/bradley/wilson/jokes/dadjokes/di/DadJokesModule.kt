package com.bradley.wilson.jokes.dadjokes.di

import com.bradley.wilson.jokes.dadjokes.DadJokesRepository
import com.bradley.wilson.jokes.dadjokes.datasources.DadJokeDataSource
import com.bradley.wilson.jokes.dadjokes.datasources.remote.DadJokeApi
import com.bradley.wilson.jokes.dadjokes.datasources.remote.DadJokeApiService
import com.bradley.wilson.jokes.dadjokes.datasources.remote.DadJokeRemoteDataSource
import com.bradley.wilson.jokes.dadjokes.mapper.DadJokeMapper
import com.bradley.wilson.jokes.dadjokes.usecases.FetchRandomDadJokeUseCase
import com.bradley.wilson.jokes.dadjokes.usecases.SearchDadJokesUseCase
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

val dadJokesModule: Module = module {
    single { DadJokeDataSource(get(), get()) as DadJokesRepository }
    factory { DadJokeRemoteDataSource(get()) }
    factory {
        DadJokeApiService(
            get(),
            get<Retrofit>().create(DadJokeApi::class.java)
        )
    }
    factory { DadJokeMapper() }
    factory { FetchRandomDadJokeUseCase(get()) }
    factory { SearchDadJokesUseCase(get()) }
}