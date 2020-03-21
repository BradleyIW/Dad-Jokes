package com.bradley.wilson.jokes.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bradley.wilson.jokes.core.exceptions.Failure
import com.bradley.wilson.jokes.dadjokes.mapper.DadJokeMapper
import com.bradley.wilson.jokes.dadjokes.usecases.DadJoke
import com.bradley.wilson.jokes.dadjokes.usecases.SearchDadJokeParams
import com.bradley.wilson.jokes.dadjokes.usecases.SearchDadJokesUseCase
import com.bradley.wilson.jokes.home.DadJokeItem

class SearchViewModel(
    private val searchDadJokesUseCase: SearchDadJokesUseCase,
    private val dadJokeMapper: DadJokeMapper
) : ViewModel() {

    private val _searchResultsLiveData = MutableLiveData<List<DadJokeItem>>()
    val searchResultsLiveData: LiveData<List<DadJokeItem>> = _searchResultsLiveData

    fun onSearchQueryEntered(searchQuery: String) {
        searchDadJokesUseCase(viewModelScope, SearchDadJokeParams(searchQuery)) {
            it.fold(::handleFailure, ::handleSearchSuccess)
        }
    }

    private fun handleSearchSuccess(jokes: List<DadJoke>) {
        _searchResultsLiveData.postValue(jokes.map {
            Log.e("SearchViewModel", it.joke)
            dadJokeMapper.fromDadJoke(it)
        })
    }

    private fun handleFailure(failure: Failure) {
        Log.e("SearchViewModel", "Something went wrong $failure")
    }
}