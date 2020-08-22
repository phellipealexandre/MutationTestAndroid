package com.ph.mutationtestandroid

import com.ph.mutationtestandroid.counter.CounterRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class CounterRepositoryTest {

    private val counterRepository = CounterRepository()

    @Test
    fun `Return zero content when counter is 0`() = runBlocking {
        val counter = 0

        val requestCountContent = counterRepository.requestCountContent(counter)

        assertEquals("Zero", requestCountContent)
    }

    @Test
    fun `Return one content when counter is 1`() = runBlocking {
        val counter = 1

        val requestCountContent = counterRepository.requestCountContent(counter)

        assertEquals("One", requestCountContent)
    }

    @Test
    fun `Return two content when counter is 2`() = runBlocking {
        val counter = 2

        val requestCountContent = counterRepository.requestCountContent(counter)

        assertEquals("Two", requestCountContent)
    }

    @Test
    fun `Return three content when counter is 3`() = runBlocking {
        val counter = 3

        val requestCountContent = counterRepository.requestCountContent(counter)

        assertEquals("Three", requestCountContent)
    }

    @Test
    fun `Return maximum request content when counter is more than 3`() = runBlocking {
        val counter = 4

        val requestCountContent = counterRepository.requestCountContent(counter)

        assertEquals("Maximum request reached", requestCountContent)
    }
}