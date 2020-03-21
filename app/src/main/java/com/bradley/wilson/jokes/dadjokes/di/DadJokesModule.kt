package com.bradley.wilson.jokes.dadjokes.di

import com.bradley.wilson.jokes.dadjokes.DadJokesRepository
import com.bradley.wilson.jokes.dadjokes.datasources.DadJokeDataSource
import com.bradley.wilson.jokes.dadjokes.datasources.remote.DadJokeApi
import com.bradley.wilson.jokes.dadjokes.datasources.remote.DadJokeApiService
import com.bradley.wilson.jokes.dadjokes.datasources.remote.DadJokeRemoteDataSource
import com.bradley.wilson.jokes.dadjokes.mapper.DadJokeMapper
import com.bradley.wilson.jokes.dadjokes.usecases.FetchDadJokeOfTheDayUseCase
import com.bradley.wilson.jokes.dadjokes.usecases.SearchDadJokesUseCase
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

val dadJokesModule: Module = module {
    single { DadJokeDataSource(get(), get()) as DadJokesRepository }
    factory { DadJokeRemoteDataSource(get()) }
    factory { DadJokeApiService(get<Retrofit>().create(DadJokeApi::class.java)) }
    factory { DadJokeMapper() }
    factory { FetchDadJokeOfTheDayUseCase(get()) }
    factory { SearchDadJokesUseCase(get()) }
}