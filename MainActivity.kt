package com.marc0dev.patternObserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import com.marc0dev.patternObserver.viewmodels.CountViewModel

class MainActivity : AppCompatActivity() {
    private val countViewModel: CountViewModel = CountViewModel.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myText: TextView = findViewById(R.id.id_value)
        val myButtonIncrement: Button = findViewById(R.id.id_button_increment)
        val myButtonDecrement: Button = findViewById(R.id.id_button_decrement)

        countViewModel.getCurrentName().observe(this, Observer { value ->  myText.text = value.toString()})

        myButtonIncrement.setOnClickListener {
            countViewModel.incrementValue()
        }
        myButtonDecrement.setOnClickListener {
            countViewModel.decrementValue()
        }

    }
}