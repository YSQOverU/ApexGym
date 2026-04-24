package com.example.apexgym

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class ClienteActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        dbHelper = DatabaseHelper(this)

        val etNombre = findViewById<TextInputEditText>(R.id.etNombre)
        val etApellido = findViewById<TextInputEditText>(R.id.etApellido)
        val btnGuardar = findViewById<MaterialButton>(R.id.btnGuardar)
        val btnConsultar = findViewById<MaterialButton>(R.id.btnConsultar)

        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()

            if (nombre.isNotEmpty() && apellido.isNotEmpty()) {
                val status = dbHelper.registrarCliente(nombre, apellido, "N/A")
                if (status > -1) {
                    Toast.makeText(this, "Cliente Registrado", Toast.LENGTH_SHORT).show()
                    etNombre.text?.clear()
                    etApellido.text?.clear()
                } else {
                    Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Nombre y Apellido son obligatorios", Toast.LENGTH_SHORT).show()
            }
        }

        btnConsultar.setOnClickListener {
            val res = dbHelper.getAllClientes()
            if (res != null && res.count > 0) {
                Toast.makeText(this, "Clientes en base de datos: ${res.count}", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No hay clientes registrados", Toast.LENGTH_SHORT).show()
            }
        }
    }
}