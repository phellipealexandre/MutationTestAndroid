package com.ph.mutationtestandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private var counter = 0

    private val viewModel: CounterViewModel by lazy {
        ViewModelProvider(this, CounterViewModelFactory()).get(CounterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeChanges()

        sendButton.setOnClickListener {
            counterTextView.text = getString(R.string.counter_title, counter.toString())
            viewModel.requestContent(counter)
            counter++
        }
    }

    private fun observeChanges() {
        viewModel.counterResponse.observe(this, Observer {
            responseTextView.text = it
        })
    }
}