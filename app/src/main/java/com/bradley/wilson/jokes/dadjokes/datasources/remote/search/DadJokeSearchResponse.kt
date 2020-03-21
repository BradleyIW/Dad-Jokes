package com.bradley.wilson.jokes.dadjokes.datasources.remote.search

import com.bradley.wilson.jokes.dadjokes.datasources.remote.DadJokeResponse
import com.google.gson.annotations.SerializedName

data class DadJokeSearchResponse(
    @SerializedName(RESULTS_KEY)
    val results: List<DadJokeResponse>
) {
    companion object {
        private const val RESULTS_KEY = "results"
    }
}