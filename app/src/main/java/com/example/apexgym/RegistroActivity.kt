package com.example.apexgym

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val dbHelper = DatabaseHelper(this)
        val etUser = findViewById<TextInputEditText>(R.id.etRegUser)
        val etPass = findViewById<TextInputEditText>(R.id.etRegPass)

        // Lógica del botón de regreso nativo
        findViewById<ImageButton>(R.id.btnRegresar).setOnClickListener { finish() }

        // Lógica funcional para guardar el usuario
        findViewById<MaterialButton>(R.id.btnGuardarRegistro).setOnClickListener {
            val user = etUser.text.toString().trim()
            val pass = etPass.text.toString().trim()

            if (user.isNotEmpty() && pass.isNotEmpty()) {
                val exito = dbHelper.registrarUsuario(user, pass)
                if (exito) {
                    Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show()
                    finish() // Cierra la pantalla y vuelve al login automáticamente
                } else {
                    Toast.makeText(this, "Error: El usuario ya existe", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Llena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}