package com.ph.mutationtestandroid.counter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ph.mutationtestandroid.R
import com.ph.mutationtestandroid.error.ErrorActivity
import com.ph.mutationtestandroid.error.ErrorModel
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
            if (counter <= 4) {
                incrementCount()
            } else {
                navigateToError()
            }
        }
    }

    private fun incrementCount() {
        counterTextView.text = getString(R.string.counter_title, counter.toString())
        viewModel.requestContent(counter)
        counter++
    }

    private fun observeChanges() {
        viewModel.counterResponse.observe(this, Observer {
            responseTextView.text = it
        })
    }

    private fun navigateToError() {
        val intent = Intent(this, ErrorActivity::class.java).apply {
            val errorModel = ErrorModel("MaximumLimitReached")
            putExtra("errorModel", errorModel)
        }

        startActivity(intent)
    }
}