package com.kousenit.jokesapp

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class JokeApiTest {
    @Test
    fun `get joke using retrofit`() = runBlocking {
        val jokeResult = JokeApi.retrofitService.getJokeResult()
        println(jokeResult.value.joke)
        assertNotNull(jokeResult)
    }
}