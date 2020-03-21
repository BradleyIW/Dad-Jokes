package com.bradley.wilson.jokes.dadjokes.mapper

import com.bradley.wilson.jokes.dadjokes.datasources.remote.DadJokeResponse
import com.bradley.wilson.jokes.dadjokes.usecases.DadJoke

class DadJokeMapper {

    fun fromResponse(dadJokeResponse: DadJokeResponse) =
        DadJoke(joke = dadJokeResponse.joke)
}