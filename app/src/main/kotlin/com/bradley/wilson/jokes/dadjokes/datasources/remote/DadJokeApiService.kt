package com.bradley.wilson.jokes.dadjokes.datasources.remote

import com.bradley.wilson.jokes.core.functional.map
import com.bradley.wilson.jokes.core.network.ApiService

class DadJokeApiService(
    private val api: DadJokeApi,
    private val apiService: ApiService = ApiService()
) {
    suspend fun jokeOfTheDay() =
        apiService.request { api.randomDadJoke() }

    suspend fun searchDadJokes(searchTerm: String) =
        apiService.request { api.searchDadJokes(searchTerm) }
            .map {
                it.results
            }
}