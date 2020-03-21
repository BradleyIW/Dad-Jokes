package com.bradley.wilson.jokes.dadjokes.usecases

import com.bradley.wilson.jokes.core.exceptions.Failure
import com.bradley.wilson.jokes.core.functional.Either
import com.bradley.wilson.jokes.core.usecase.UseCase
import com.bradley.wilson.jokes.dadjokes.DadJokesRepository

class SearchDadJokesUseCase(private val dadJokeRepository: DadJokesRepository) :
    UseCase<List<DadJoke>, SearchDadJokeParams>() {

    override suspend fun run(params: SearchDadJokeParams): Either<Failure, List<DadJoke>> =
        dadJokeRepository.searchDadJokes(params.searchTerm)
}

data class SearchDadJokeParams(val searchTerm: String)