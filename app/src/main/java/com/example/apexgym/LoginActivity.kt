package com.example.apexgym

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    // Instanciamos tu conexión a la base de datos
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        dbHelper = DatabaseHelper(this)

        // Enlazamos los elementos de la interfaz visual con el código
        val etUser = findViewById<TextInputEditText>(R.id.etUser)
        val etPass = findViewById<TextInputEditText>(R.id.etPass)
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        val btnRegistro = findViewById<MaterialButton>(R.id.btnIrARegistro)

        // LÓGICA DEL BOTÓN: INICIAR SESIÓN
        btnLogin.setOnClickListener {
            val user = etUser.text.toString().trim()
            val pass = etPass.text.toString().trim()

            // Validación de seguridad básica (evitar campos vacíos)
            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa credenciales válidas", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Consultamos la Base de Datos
            val credencialesValidas = dbHelper.validarLogin(user, pass)

            if (credencialesValidas) {
                Toast.makeText(this, "Acceso Autorizado", Toast.LENGTH_SHORT).show()

                // Si es correcto, abrimos el Dashboard (MainActivity)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                // Cerramos esta pantalla para que el usuario no pueda "regresar" al login con la flecha
                finish()
            } else {
                Toast.makeText(this, "Acceso Denegado: Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show()
            }
        }

        // LÓGICA DEL BOTÓN: REGISTRARSE
        btnRegistro.setOnClickListener {
            // Abrimos la pantalla de registro
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
    }
}