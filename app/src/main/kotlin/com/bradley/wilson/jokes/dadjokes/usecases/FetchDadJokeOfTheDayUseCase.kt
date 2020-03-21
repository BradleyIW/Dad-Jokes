package com.bradley.wilson.jokes.dadjokes.usecases

import com.bradley.wilson.jokes.core.exceptions.Failure
import com.bradley.wilson.jokes.core.functional.Either
import com.bradley.wilson.jokes.core.usecase.UseCase
import com.bradley.wilson.jokes.dadjokes.DadJokesRepository

class FetchDadJokeOfTheDayUseCase(private val dadJokesRepository: DadJokesRepository) :
    UseCase<DadJoke, Unit>() {

    override suspend fun run(params: Unit): Either<Failure, DadJoke> =
        dadJokesRepository.dadJokeOfTheDay()

}