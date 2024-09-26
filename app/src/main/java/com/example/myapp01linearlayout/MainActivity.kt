package com.example.myapp01linearlayout

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var districtEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        firstNameEditText = findViewById(R.id.first_name_edit_text)
        lastNameEditText = findViewById(R.id.last_name_edit_text)
        districtEditText = findViewById(R.id.district_edit_text)
        ageEditText = findViewById(R.id.age_edit_text)
        textView = findViewById(R.id.text_view_id)

        val sendButton = findViewById<Button>(R.id.send_button)
        val deleteButton = findViewById<Button>(R.id.delete_button)

        sendButton.setOnClickListener {
            val firstName: String = firstNameEditText.getText().toString()
            val lastName: String = lastNameEditText.getText().toString()
            val district: String = districtEditText.getText().toString()
            val age: String = ageEditText.getText().toString()

            val displayText = """
                First Name: $firstName
                Last Name: $lastName
                District: $district
                Age: $age
                """.trimIndent()
            textView.text = displayText
        }

        deleteButton.setOnClickListener { textView.text = "" }
    }
}