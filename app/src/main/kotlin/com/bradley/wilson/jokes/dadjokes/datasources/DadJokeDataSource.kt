package com.bradley.wilson.jokes.dadjokes.datasources

import com.bradley.wilson.jokes.core.functional.map
import com.bradley.wilson.jokes.dadjokes.DadJokesRepository
import com.bradley.wilson.jokes.dadjokes.datasources.remote.DadJokeRemoteDataSource
import com.bradley.wilson.jokes.dadjokes.mapper.DadJokeMapper

class DadJokeDataSource(
    private val remoteDataSource: DadJokeRemoteDataSource,
    private val dadJokeMapper: DadJokeMapper
) : DadJokesRepository {

    override suspend fun randomDadJoke() =
        remoteDataSource.jokeOfTheDay().map {
            dadJokeMapper.fromDadJokeResponse(it)
        }

    override suspend fun searchDadJokes(searchTerm: String) =
        remoteDataSource.searchDadJokes(searchTerm).map { dadJokes ->
            dadJokes.map {
                dadJokeMapper.fromDadJokeResponse(it)
            }
        }

}