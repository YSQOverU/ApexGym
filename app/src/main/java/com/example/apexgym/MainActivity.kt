package com.example.apexgym

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Conecta con el diseño XML que tiene la cabecera azul y los cuadros
        setContentView(R.layout.activity_main)

        // ---------------------------------------------------------
        // 1. CONFIGURACIÓN DEL BOTÓN CERRAR SESIÓN (LOGOUT)
        // ---------------------------------------------------------
        val btnLogout = findViewById<ImageButton>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            // Estas banderas limpian la memoria para que al dar "atrás" no regrese al panel
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish() // Cierra el MainActivity
        }

        // ---------------------------------------------------------
        // 2. CONFIGURACIÓN DE LOS MÓDULOS (TARJETAS)
        // ---------------------------------------------------------

        // Módulo de Usuarios (Este es el que ya tienes programado)
        val cardUsuarios = findViewById<MaterialCardView>(R.id.cardUsuarios)
        cardUsuarios.setOnClickListener {
            val intent = Intent(this, GestionUsuariosActivity::class.java)
            startActivity(intent)
        }

        // Módulo de Reportes (Abre su actividad correspondiente)
        val cardReportes = findViewById<MaterialCardView>(R.id.cardReportes)
        cardReportes.setOnClickListener {
            val intent = Intent(this, ReportesActivity::class.java)
            startActivity(intent)
        }

        // Módulos de Relleno (Para evitar que la app se cierre al tocarlos)
        val cardClientes = findViewById<MaterialCardView>(R.id.cardClientes)
        val cardInventario = findViewById<MaterialCardView>(R.id.cardInventario)
        val cardAsistencia = findViewById<MaterialCardView>(R.id.cardAsistencia)

        // Función rápida para mostrar un aviso de "En construcción"
        val avisoConstruccion = {
            Toast.makeText(this, "Módulo disponible en la siguiente versión", Toast.LENGTH_SHORT).show()
        }

        cardClientes.setOnClickListener { avisoConstruccion() }
        cardInventario.setOnClickListener { avisoConstruccion() }
        cardAsistencia.setOnClickListener { avisoConstruccion() }
    }
}