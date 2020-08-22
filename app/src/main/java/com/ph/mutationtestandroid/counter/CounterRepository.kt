package com.ph.mutationtestandroid.counter

import kotlinx.coroutines.delay

class CounterRepository {

    suspend fun requestCountContent(count: Int): String {
        delay(1000)

        return when (count) {
            0 -> "Zero"
            1 -> "One"
            2 -> "Two"
            3 -> "Three"
            else -> "Maximum request reached"
        }
    }
}