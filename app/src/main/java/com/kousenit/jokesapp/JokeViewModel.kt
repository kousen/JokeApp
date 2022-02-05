package com.kousenit.jokesapp

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {

    private val _joke = MutableLiveData("Click button to get a joke")
    val joke: LiveData<String>
        get() = _joke

    fun refreshJoke() {
        viewModelScope.launch {
            _joke.value = JokeApi.retrofitService.getJokeResult().value.joke
        }
    }
}