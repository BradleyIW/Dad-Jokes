package com.bradley.wilson.jokes.dadjokes.datasources.remote

import com.bradley.wilson.jokes.core.exceptions.Failure
import com.bradley.wilson.jokes.core.functional.Either

class DadJokeRemoteDataSource(private val dadJokeApiService: DadJokeApiService) {

    suspend fun jokeOfTheDay(): Either<Failure, DadJokeResponse> =
        dadJokeApiService.jokeOfTheDay()

    suspend fun searchDadJokes(searchTerm: String): Either<Failure, List<DadJokeResponse>> =
        dadJokeApiService.searchDadJokes(searchTerm)

}