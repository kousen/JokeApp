package com.kousenit.jokesapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://api.icndb.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface JokeService {
    @GET("jokes/random/")
    suspend fun getJokeResult(
        @Query("limitTo") limitTo: List<String> = listOf("nerdy"),
        @Query("firstName") firstName: String = "Carlos",
        @Query("lastName") lastName: String = "Ray"
    ): JokeResult
}

object JokeApi {
    val retrofitService: JokeService by lazy {
        retrofit.create(JokeService::class.java)
    }
}

data class JokeValue(
    val id: Int,
    val joke: String,
    val categories: List<String>,
)

data class JokeResult(
    val type: String,
    val value: JokeValue,
)