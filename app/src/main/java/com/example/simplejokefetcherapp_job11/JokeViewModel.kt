package com.example.simplejokefetcherapp_job11

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JokeViewModel : ViewModel() {
    private val jokeRepository = JokeRepository()

    private val _joke = MutableLiveData<Joke?>()
    val joke: LiveData<Joke?> = _joke

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun fetchRandomJoke() {
        jokeRepository.fetchRandomJoke { joke, error ->
            _joke.postValue(joke)
            _errorMessage.postValue(error)
        }
    }
}