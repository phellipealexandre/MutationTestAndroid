package com.ph.mutationtestandroid.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CounterViewModel(
    private val counterRepository: CounterRepository
) : ViewModel() {

    private val _counterResponse = MutableLiveData<String>()
    val counterResponse: LiveData<String> = _counterResponse

    fun requestContent(counter: Int) {
        viewModelScope.launch {
            val content = counterRepository.requestCountContent(counter)
            _counterResponse.postValue(content)
        }
    }
}