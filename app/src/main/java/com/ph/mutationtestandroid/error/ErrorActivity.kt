package com.ph.mutationtestandroid.error

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ph.mutationtestandroid.R
import kotlinx.android.synthetic.main.activity_error.*

class ErrorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        val errorModel = intent.getParcelableExtra<ErrorModel>("errorModel")
        errorTextView.text = errorModel!!.errorMessage
    }
}