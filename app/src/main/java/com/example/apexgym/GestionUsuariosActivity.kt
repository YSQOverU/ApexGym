package com.example.apexgym

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GestionUsuariosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_usuarios)

        val dbHelper = DatabaseHelper(this)
        val etId = findViewById<EditText>(R.id.etCrudId)
        val etUser = findViewById<EditText>(R.id.etCrudUser)
        val etPass = findViewById<EditText>(R.id.etCrudPass)

        // --- EL BOTÓN DE REGRESO ---
        findViewById<ImageButton>(R.id.btnRegresarCrud).setOnClickListener {
            finish() // Cierra esta pantalla y vuelve al Dashboard
        }

        findViewById<Button>(R.id.btnCrudBuscar).setOnClickListener {
            val cursor = dbHelper.buscarUsuario(etUser.text.toString())
            if (cursor.moveToFirst()) {
                etId.setText(cursor.getInt(0).toString())
                etPass.setText(cursor.getString(2))
            } else {
                Toast.makeText(this, "No encontrado", Toast.LENGTH_SHORT).show()
            }
            cursor.close()
        }

        findViewById<Button>(R.id.btnCrudActualizar).setOnClickListener {
            val id = etId.text.toString().toIntOrNull()
            if (id != null && dbHelper.actualizarUsuario(id, etUser.text.toString(), etPass.text.toString())) {
                Toast.makeText(this, "Actualizado", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btnCrudBorrar).setOnClickListener {
            val id = etId.text.toString().toIntOrNull()
            if (id != null && dbHelper.eliminarUsuario(id)) {
                Toast.makeText(this, "Eliminado", Toast.LENGTH_SHORT).show()
                etId.text.clear(); etUser.text.clear(); etPass.text.clear()
            }
        }
    }
}