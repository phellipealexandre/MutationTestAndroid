package com.ph.mutationtestandroid

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ph.mutationtestandroid.counter.CounterRepository
import com.ph.mutationtestandroid.counter.CounterViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CounterViewModelTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    private val counterRepository = mockk<CounterRepository>()
    private val viewModel = CounterViewModel(counterRepository)

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Default)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Emit content when count content is requested`() {
        coEvery { counterRepository.requestCountContent(1) } returns "One"

        viewModel.requestContent(1)

        viewModel.counterResponse.observeForever {
            assertEquals("One", it)
        }
    }
}