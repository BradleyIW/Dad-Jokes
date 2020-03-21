package com.bradley.wilson.jokes.dadjokes

import com.bradley.wilson.jokes.core.exceptions.Failure
import com.bradley.wilson.jokes.core.functional.Either
import com.bradley.wilson.jokes.dadjokes.usecases.DadJoke

interface DadJokesRepository {

    suspend fun randomDadJoke(): Either<Failure, DadJoke>

    suspend fun searchDadJokes(searchTerm: String): Either<Failure, List<DadJoke>>

}