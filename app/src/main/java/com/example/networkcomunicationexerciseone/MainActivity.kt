package com.example.networkcomunicationexerciseone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var textView: TextView
    private lateinit var button: Button
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_fragment)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editTextNumber)
        button = findViewById(R.id.button)


        button.setOnClickListener {


            runBlocking {
                provideValue()
                incrementer()
            }
        }
    }
    private suspend fun provideValue() {
        delay(2000)
    }

    private fun incrementer(){
        val userTextInput = editText.text.toString()
        val userTextInput2 = userTextInput.toInt()
        val result = "This is your input ${userTextInput2 + 1 + count++}"
        textView.text = result
    }
}