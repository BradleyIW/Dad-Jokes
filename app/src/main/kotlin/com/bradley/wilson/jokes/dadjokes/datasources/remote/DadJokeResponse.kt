package com.bradley.wilson.jokes.dadjokes.datasources.remote

import com.google.gson.annotations.SerializedName

data class DadJokeResponse(
    @SerializedName(ID_KEY)
    val id: String,

    @SerializedName(JOKE_KEY)
    val joke: String
) {

    companion object {
        private const val ID_KEY = "id"
        private const val JOKE_KEY = "joke"
    }
}