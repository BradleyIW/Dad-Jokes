package com.bradley.wilson.jokes.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bradley.wilson.jokes.core.exceptions.Failure
import com.bradley.wilson.jokes.dadjokes.mapper.DadJokeMapper
import com.bradley.wilson.jokes.dadjokes.usecases.DadJoke
import com.bradley.wilson.jokes.dadjokes.usecases.FetchRandomDadJokeUseCase

class HomeViewModel(
    private val getJokeUseCaseRandom: FetchRandomDadJokeUseCase,
    private val dadJokeMapper: DadJokeMapper
) : ViewModel() {

    private val _jokeOfTheDayLiveData = MutableLiveData<String>()
    val randomDadJokeLiveData = _jokeOfTheDayLiveData

    fun getRandomDadJoke() {
        getJokeUseCaseRandom(viewModelScope, Unit) {
            it.fold(::handleFailure, ::handleRandomJokeSuccess)
        }
    }

    private fun handleFailure(failure: Failure) {

    }

    private fun handleRandomJokeSuccess(jokeOfTheDay: DadJoke) {
        _jokeOfTheDayLiveData.postValue(dadJokeMapper.fromDadJoke(jokeOfTheDay).joke)
    }
}