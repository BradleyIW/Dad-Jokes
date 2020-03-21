package com.bradley.wilson.jokes.dadjokes.datasources.remote

import com.bradley.wilson.jokes.core.functional.map
import com.bradley.wilson.jokes.core.network.ApiService

class DadJokeApiService(
    private val api: DadJokeApi
) : ApiService() {

    suspend fun jokeOfTheDay() =
        request { api.randomDadJoke() }

    suspend fun searchDadJokes(searchTerm: String) =
        request { api.searchDadJokes(searchTerm) }
            .map {
                it.results
            }

}