package com.example.myapp002myownlinearlayout

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonCount = findViewById<Button>(R.id.buttonCount)
        val editTextInput = findViewById<EditText>(R.id.editTextInput)
        val textViewWords = findViewById<TextView>(R.id.textViewWords)
        val textViewVowels = findViewById<TextView>(R.id.textViewVowels)
        val textViewConsonants = findViewById<TextView>(R.id.textViewConsonants)

        buttonCount.setOnClickListener {
            val inputText = editTextInput.text.toString()
            val wordCount = countWords(inputText)
            val vowelCount = countVowels(inputText)
            val consonantCount = countConsonants(inputText)

            textViewWords.text = "Words: $wordCount"
            textViewVowels.text = "Vowels: $vowelCount"
            textViewConsonants.text = "Consonants: $consonantCount"
        }
    }

    private fun countWords(text: String): Int {
        return text.trim().split("\\s+".toRegex()).size
    }

    private fun countVowels(text: String): Int {
        return text.lowercase().count { it in "aeiou" }
    }

    private fun countConsonants(text: String): Int {
        return text.lowercase().count { it in 'a'..'z' && it !in "aeiou" }
    }
}