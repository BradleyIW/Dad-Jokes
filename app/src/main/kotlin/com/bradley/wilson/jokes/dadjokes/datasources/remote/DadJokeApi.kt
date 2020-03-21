package com.bradley.wilson.jokes.dadjokes.datasources.remote

import com.bradley.wilson.jokes.dadjokes.datasources.remote.search.DadJokeSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DadJokeApi {

    @GET(RANDOM_JOKE_ENDPOINT)
    suspend fun randomDadJoke(): Response<DadJokeResponse>

    @GET(SEARCH_ENDPOINT)
    suspend fun searchDadJokes(@Query(SEARCH_TERM_QUERY) searchTerm: String): Response<DadJokeSearchResponse>

    companion object {
        private const val RANDOM_JOKE_ENDPOINT = "/"
        private const val SEARCH_ENDPOINT = "/search"
        private const val SEARCH_TERM_QUERY = "term"
    }
}