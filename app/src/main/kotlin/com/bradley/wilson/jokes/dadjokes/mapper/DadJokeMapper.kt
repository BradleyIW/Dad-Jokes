package com.bradley.wilson.jokes.dadjokes.mapper

import com.bradley.wilson.jokes.dadjokes.datasources.remote.DadJokeResponse
import com.bradley.wilson.jokes.dadjokes.usecases.DadJoke
import com.bradley.wilson.jokes.home.DadJokeItem

class DadJokeMapper {

    fun fromDadJokeResponse(dadJokeResponse: DadJokeResponse) =
        DadJoke(
            id = dadJokeResponse.id,
            joke = dadJokeResponse.joke
        )

    fun fromDadJoke(dadJoke: DadJoke): DadJokeItem =
        DadJokeItem(
            joke = dadJoke.joke
        )
}