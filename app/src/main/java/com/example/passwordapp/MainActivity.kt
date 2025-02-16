package com.example.passwordapp

import android.os.Bundle
import android.text.InputType
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ініціалізація елементів інтерфейсу
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val radioShow = findViewById<RadioButton>(R.id.radioShow)
        val radioHide = findViewById<RadioButton>(R.id.radioHide)
        val buttonOk = findViewById<Button>(R.id.buttonOk)
        val textViewOutput = findViewById<TextView>(R.id.textViewOutput)

        // Логіка зміни режиму відображення паролю
        radioShow.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                editTextPassword.inputType = InputType.TYPE_CLASS_TEXT
            }
        }

        radioHide.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                editTextPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }

        // Логіка кнопки "ОК"
        buttonOk.setOnClickListener {
            val password = editTextPassword.text.toString()

            if (password.isEmpty()) {
                // Відображення повідомлення, якщо поле порожнє
                Toast.makeText(this, "Введіть пароль", Toast.LENGTH_SHORT).show()
            } else {
                // Виведення паролю у TextView
                textViewOutput.text = "Введений пароль: $password"
            }
        }
    }
}
