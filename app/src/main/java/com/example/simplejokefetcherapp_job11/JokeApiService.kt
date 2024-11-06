package com.example.simplejokefetcherapp_job11

import retrofit2.Call
import retrofit2.http.GET

interface JokeApiService {
    @GET(" https://official-joke-api.appspot.com/random_joke")
    fun getRandomJoke(): Call<Joke>
}